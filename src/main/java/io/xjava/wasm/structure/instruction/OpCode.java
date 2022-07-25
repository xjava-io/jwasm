package io.xjava.wasm.structure.instruction;

import static io.xjava.wasm.structure.instruction.InstructionGroup.*;
import static io.xjava.wasm.structure.instruction.OpCodeType.*;

/**
 * <h3>2.4 Instructions</h3>
 * WebAssembly code consists of sequences of instructions. Its computational
 * model is based on a stack machine in that instructions manipulate values
 * on an implicit operand stack, consuming (popping) argument values and
 * producing or returning (pushing) result values.
 * <p>
 * In addition to dynamic operands from the stack, some instructions also
 * have static immediate arguments, typically indices or type annotations,
 * which are part of the instruction itself.
 * <p>
 * Some instructions are structured in that they bracket nested sequences
 * of instructions.
 *
 * @author AlphaLxy
 * @see Instruction
 * @see InstructionGroup
 */
public enum OpCode {
    // @formatter:off
    // 2.4.8 Control Instructions
    UNREACHABLE                   (CONTROL,    NO_OPERAND,    (byte)0x00),
    NOP                           (CONTROL,    NO_OPERAND,    (byte)0x01),
    BLOCK                         (CONTROL,    SIMPLE_BLOCK,  (byte)0x02),
    LOOP                          (CONTROL,    SIMPLE_BLOCK,  (byte)0x03),
    IF                            (CONTROL,    IF_ELSE_BLOCK, (byte)0x04),
    BR                            (CONTROL,    INDEX,         (byte)0x0C),
    BR_IF                         (CONTROL,    INDEX,         (byte)0x0D),
    BR_TABLE                      (CONTROL,    INDEXES,       (byte)0x0E),
    RETURN                        (CONTROL,    NO_OPERAND,    (byte)0x0F),
    CALL                          (CONTROL,    INDEX,         (byte)0x10),
    CALL_INDIRECT                 (CONTROL,    INDEX_INDEX,   (byte)0x11),

    // 2.4.3 Reference Instructions
    REF_NULL                      (REFERENCE,  VALUE_TYPE,    (byte)0xD0),
    REF_IS_NULL                   (REFERENCE,  NO_OPERAND,    (byte)0xD1),
    REF_FUNC                      (REFERENCE,  INDEX,         (byte)0xD2),

    // 2.4.4 Parametric Instructions
    DROP                          (PARAMETRIC, NO_OPERAND,    (byte)0x1A),
    SELECT                        (PARAMETRIC, NO_OPERAND,    (byte)0x1B),
    SELECT_TYPES                  (PARAMETRIC, VALUE_TYPES,   (byte)0x1C),

    // 2.4.5 Variable Instructions
    LOCAL_GET                     (VARIABLE,   INDEX,         (byte)0x20),
    LOCAL_SET                     (VARIABLE,   INDEX,         (byte)0x21),
    LOCAL_TEE                     (VARIABLE,   INDEX,         (byte)0x22),
    GLOBAL_GET                    (VARIABLE,   INDEX,         (byte)0x23),
    GLOBAL_SET                    (VARIABLE,   INDEX,         (byte)0x24),

    // 2.4.6 Table Instructions
    TABLE_GET                     (TABLE,      INDEX,         (byte)0x25),
    TABLE_SET                     (TABLE,      INDEX,         (byte)0x26),
    TABLE_INIT                    (TABLE,      INDEX_INDEX,   (byte)0xFC,  12),
    ELEM_DROP                     (TABLE,      INDEX,         (byte)0xFC,  13),
    TABLE_COPY                    (TABLE,      INDEX_INDEX,   (byte)0xFC,  14),
    TABLE_GROW                    (TABLE,      INDEX,         (byte)0xFC,  15),
    TABLE_SIZE                    (TABLE,      INDEX,         (byte)0xFC,  16),
    TABLE_FILL                    (TABLE,      INDEX,         (byte)0xFC,  17),

    // 2.4.7 Memory Instructions
    I32_LOAD                      (MEMORY,     INDEX_INDEX,   (byte)0x28),
    I64_LOAD                      (MEMORY,     INDEX_INDEX,   (byte)0x29),
    F32_LOAD                      (MEMORY,     INDEX_INDEX,   (byte)0x2A),
    F64_LOAD                      (MEMORY,     INDEX_INDEX,   (byte)0x2B),
    I32_LOAD8_S                   (MEMORY,     INDEX_INDEX,   (byte)0x2C),
    I32_LOAD8_U                   (MEMORY,     INDEX_INDEX,   (byte)0x2D),
    I32_LOAD16_S                  (MEMORY,     INDEX_INDEX,   (byte)0x2E),
    I32_LOAD16_U                  (MEMORY,     INDEX_INDEX,   (byte)0x2F),
    I64_LOAD8_S                   (MEMORY,     INDEX_INDEX,   (byte)0x30),
    I64_LOAD8_U                   (MEMORY,     INDEX_INDEX,   (byte)0x31),
    I64_LOAD16_S                  (MEMORY,     INDEX_INDEX,   (byte)0x32),
    I64_LOAD16_U                  (MEMORY,     INDEX_INDEX,   (byte)0x33),
    I64_LOAD32_S                  (MEMORY,     INDEX_INDEX,   (byte)0x34),
    I64_LOAD32_U                  (MEMORY,     INDEX_INDEX,   (byte)0x35),
    I32_STORE                     (MEMORY,     INDEX_INDEX,   (byte)0x36),
    I64_STORE                     (MEMORY,     INDEX_INDEX,   (byte)0x37),
    F32_STORE                     (MEMORY,     INDEX_INDEX,   (byte)0x38),
    F64_STORE                     (MEMORY,     INDEX_INDEX,   (byte)0x39),
    I32_STORE8                    (MEMORY,     INDEX_INDEX,   (byte)0x3A),
    I32_STORE16                   (MEMORY,     INDEX_INDEX,   (byte)0x3B),
    I64_STORE8                    (MEMORY,     INDEX_INDEX,   (byte)0x3C),
    I64_STORE16                   (MEMORY,     INDEX_INDEX,   (byte)0x3D),
    I64_STORE32                   (MEMORY,     INDEX_INDEX,   (byte)0x3E),
    MEMORY_SIZE                   (MEMORY,     INDEX,         (byte)0x3F),
    MEMORY_GROW                   (MEMORY,     INDEX,         (byte)0x40),
    MEMORY_INIT                   (MEMORY,     INDEX_INDEX,   (byte)0xFC,   8),
    DATA_DROP                     (MEMORY,     INDEX,         (byte)0xFC,   9),
    MEMORY_COPY                   (MEMORY,     INDEX_INDEX,   (byte)0xFC,  10),
    MEMORY_FILL                   (MEMORY,     INDEX,         (byte)0xFC,  11),

    // 2.4.1 Numeric Instructions
    I32_CONST                     (NUMERIC,    CONST,         (byte)0x41),
    I64_CONST                     (NUMERIC,    CONST,         (byte)0x42),
    F32_CONST                     (NUMERIC,    CONST,         (byte)0x43),
    F64_CONST                     (NUMERIC,    CONST,         (byte)0x44),
    I32_EQZ                       (NUMERIC,    NO_OPERAND,    (byte)0x45),
    I32_EQ                        (NUMERIC,    NO_OPERAND,    (byte)0x46),
    I32_NE                        (NUMERIC,    NO_OPERAND,    (byte)0x47),
    I32_LT_S                      (NUMERIC,    NO_OPERAND,    (byte)0x48),
    I32_LT_U                      (NUMERIC,    NO_OPERAND,    (byte)0x49),
    I32_GT_S                      (NUMERIC,    NO_OPERAND,    (byte)0x4A),
    I32_GT_U                      (NUMERIC,    NO_OPERAND,    (byte)0x4B),
    I32_LE_S                      (NUMERIC,    NO_OPERAND,    (byte)0x4C),
    I32_LE_U                      (NUMERIC,    NO_OPERAND,    (byte)0x4D),
    I32_GE_S                      (NUMERIC,    NO_OPERAND,    (byte)0x4E),
    I32_GE_U                      (NUMERIC,    NO_OPERAND,    (byte)0x4F),
    I64_EQZ                       (NUMERIC,    NO_OPERAND,    (byte)0x50),
    I64_EQ                        (NUMERIC,    NO_OPERAND,    (byte)0x51),
    I64_NE                        (NUMERIC,    NO_OPERAND,    (byte)0x52),
    I64_LT_S                      (NUMERIC,    NO_OPERAND,    (byte)0x53),
    I64_LT_U                      (NUMERIC,    NO_OPERAND,    (byte)0x54),
    I64_GT_S                      (NUMERIC,    NO_OPERAND,    (byte)0x55),
    I64_GT_U                      (NUMERIC,    NO_OPERAND,    (byte)0x56),
    I64_LE_S                      (NUMERIC,    NO_OPERAND,    (byte)0x57),
    I64_LE_U                      (NUMERIC,    NO_OPERAND,    (byte)0x58),
    I64_GE_S                      (NUMERIC,    NO_OPERAND,    (byte)0x59),
    I64_GE_U                      (NUMERIC,    NO_OPERAND,    (byte)0x5A),
    F32_EQ                        (NUMERIC,    NO_OPERAND,    (byte)0x5B),
    F32_NE                        (NUMERIC,    NO_OPERAND,    (byte)0x5C),
    F32_LT                        (NUMERIC,    NO_OPERAND,    (byte)0x5D),
    F32_GT                        (NUMERIC,    NO_OPERAND,    (byte)0x5E),
    F32_LE                        (NUMERIC,    NO_OPERAND,    (byte)0x5F),
    F32_GE                        (NUMERIC,    NO_OPERAND,    (byte)0x60),
    F64_EQ                        (NUMERIC,    NO_OPERAND,    (byte)0x61),
    F64_NE                        (NUMERIC,    NO_OPERAND,    (byte)0x62),
    F64_LT                        (NUMERIC,    NO_OPERAND,    (byte)0x63),
    F64_GT                        (NUMERIC,    NO_OPERAND,    (byte)0x64),
    F64_LE                        (NUMERIC,    NO_OPERAND,    (byte)0x65),
    F64_GE                        (NUMERIC,    NO_OPERAND,    (byte)0x66),
    I32_CLZ                       (NUMERIC,    NO_OPERAND,    (byte)0x67),
    I32_CTZ                       (NUMERIC,    NO_OPERAND,    (byte)0x68),
    I32_POPCNT                    (NUMERIC,    NO_OPERAND,    (byte)0x69),
    I32_ADD                       (NUMERIC,    NO_OPERAND,    (byte)0x6A),
    I32_SUB                       (NUMERIC,    NO_OPERAND,    (byte)0x6B),
    I32_MUL                       (NUMERIC,    NO_OPERAND,    (byte)0x6C),
    I32_DIV_S                     (NUMERIC,    NO_OPERAND,    (byte)0x6D),
    I32_DIV_U                     (NUMERIC,    NO_OPERAND,    (byte)0x6E),
    I32_REM_S                     (NUMERIC,    NO_OPERAND,    (byte)0x6F),
    I32_REM_U                     (NUMERIC,    NO_OPERAND,    (byte)0x70),
    I32_AND                       (NUMERIC,    NO_OPERAND,    (byte)0x71),
    I32_OR                        (NUMERIC,    NO_OPERAND,    (byte)0x72),
    I32_XOR                       (NUMERIC,    NO_OPERAND,    (byte)0x73),
    I32_SHL                       (NUMERIC,    NO_OPERAND,    (byte)0x74),
    I32_SHR_S                     (NUMERIC,    NO_OPERAND,    (byte)0x75),
    I32_SHR_U                     (NUMERIC,    NO_OPERAND,    (byte)0x76),
    I32_ROTL                      (NUMERIC,    NO_OPERAND,    (byte)0x77),
    I32_ROTR                      (NUMERIC,    NO_OPERAND,    (byte)0x78),
    I64_CLZ                       (NUMERIC,    NO_OPERAND,    (byte)0x79),
    I64_CTZ                       (NUMERIC,    NO_OPERAND,    (byte)0x7A),
    I64_POPCNT                    (NUMERIC,    NO_OPERAND,    (byte)0x7B),
    I64_ADD                       (NUMERIC,    NO_OPERAND,    (byte)0x7C),
    I64_SUB                       (NUMERIC,    NO_OPERAND,    (byte)0x7D),
    I64_MUL                       (NUMERIC,    NO_OPERAND,    (byte)0x7E),
    I64_DIV_S                     (NUMERIC,    NO_OPERAND,    (byte)0x7F),
    I64_DIV_U                     (NUMERIC,    NO_OPERAND,    (byte)0x80),
    I64_REM_S                     (NUMERIC,    NO_OPERAND,    (byte)0x81),
    I64_REM_U                     (NUMERIC,    NO_OPERAND,    (byte)0x82),
    I64_AND                       (NUMERIC,    NO_OPERAND,    (byte)0x83),
    I64_OR                        (NUMERIC,    NO_OPERAND,    (byte)0x84),
    I64_XOR                       (NUMERIC,    NO_OPERAND,    (byte)0x85),
    I64_SHL                       (NUMERIC,    NO_OPERAND,    (byte)0x86),
    I64_SHR_S                     (NUMERIC,    NO_OPERAND,    (byte)0x87),
    I64_SHR_U                     (NUMERIC,    NO_OPERAND,    (byte)0x88),
    I64_ROTL                      (NUMERIC,    NO_OPERAND,    (byte)0x89),
    I64_ROTR                      (NUMERIC,    NO_OPERAND,    (byte)0x8A),
    F32_ABS                       (NUMERIC,    NO_OPERAND,    (byte)0x8B),
    F32_NEG                       (NUMERIC,    NO_OPERAND,    (byte)0x8C),
    F32_CEIL                      (NUMERIC,    NO_OPERAND,    (byte)0x8D),
    F32_FLOOR                     (NUMERIC,    NO_OPERAND,    (byte)0x8E),
    F32_TRUNC                     (NUMERIC,    NO_OPERAND,    (byte)0x8F),
    F32_NEAREST                   (NUMERIC,    NO_OPERAND,    (byte)0x90),
    F32_SQRT                      (NUMERIC,    NO_OPERAND,    (byte)0x91),
    F32_ADD                       (NUMERIC,    NO_OPERAND,    (byte)0x92),
    F32_SUB                       (NUMERIC,    NO_OPERAND,    (byte)0x93),
    F32_MUL                       (NUMERIC,    NO_OPERAND,    (byte)0x94),
    F32_DIV                       (NUMERIC,    NO_OPERAND,    (byte)0x95),
    F32_MIN                       (NUMERIC,    NO_OPERAND,    (byte)0x96),
    F32_MAX                       (NUMERIC,    NO_OPERAND,    (byte)0x97),
    F32_COPYSIGN                  (NUMERIC,    NO_OPERAND,    (byte)0x98),
    F64_ABS                       (NUMERIC,    NO_OPERAND,    (byte)0x99),
    F64_NEG                       (NUMERIC,    NO_OPERAND,    (byte)0x9A),
    F64_CEIL                      (NUMERIC,    NO_OPERAND,    (byte)0x9B),
    F64_FLOOR                     (NUMERIC,    NO_OPERAND,    (byte)0x9C),
    F64_TRUNC                     (NUMERIC,    NO_OPERAND,    (byte)0x9D),
    F64_NEAREST                   (NUMERIC,    NO_OPERAND,    (byte)0x9E),
    F64_SQRT                      (NUMERIC,    NO_OPERAND,    (byte)0x9F),
    F64_ADD                       (NUMERIC,    NO_OPERAND,    (byte)0xA0),
    F64_SUB                       (NUMERIC,    NO_OPERAND,    (byte)0xA1),
    F64_MUL                       (NUMERIC,    NO_OPERAND,    (byte)0xA2),
    F64_DIV                       (NUMERIC,    NO_OPERAND,    (byte)0xA3),
    F64_MIN                       (NUMERIC,    NO_OPERAND,    (byte)0xA4),
    F64_MAX                       (NUMERIC,    NO_OPERAND,    (byte)0xA5),
    F64_COPYSIGN                  (NUMERIC,    NO_OPERAND,    (byte)0xA6),
    I32_WRAP_I64                  (NUMERIC,    NO_OPERAND,    (byte)0xA7),
    I32_TRUNC_F32_S               (NUMERIC,    NO_OPERAND,    (byte)0xA8),
    I32_TRUNC_F32_U               (NUMERIC,    NO_OPERAND,    (byte)0xA9),
    I32_TRUNC_F64_S               (NUMERIC,    NO_OPERAND,    (byte)0xAA),
    I32_TRUNC_F64_U               (NUMERIC,    NO_OPERAND,    (byte)0xAB),
    I64_EXTEND_I32_S              (NUMERIC,    NO_OPERAND,    (byte)0xAC),
    I64_EXTEND_I32_U              (NUMERIC,    NO_OPERAND,    (byte)0xAD),
    I64_TRUNC_F32_S               (NUMERIC,    NO_OPERAND,    (byte)0xAE),
    I64_TRUNC_F32_U               (NUMERIC,    NO_OPERAND,    (byte)0xAF),
    I64_TRUNC_F64_S               (NUMERIC,    NO_OPERAND,    (byte)0xB0),
    I64_TRUNC_F64_U               (NUMERIC,    NO_OPERAND,    (byte)0xB1),
    F32_CONVERT_I32_S             (NUMERIC,    NO_OPERAND,    (byte)0xB2),
    F32_CONVERT_I32_U             (NUMERIC,    NO_OPERAND,    (byte)0xB3),
    F32_CONVERT_I64_S             (NUMERIC,    NO_OPERAND,    (byte)0xB4),
    F32_CONVERT_I64_U             (NUMERIC,    NO_OPERAND,    (byte)0xB5),
    F32_DEMOTE_F64                (NUMERIC,    NO_OPERAND,    (byte)0xB6),
    F64_CONVERT_I32_S             (NUMERIC,    NO_OPERAND,    (byte)0xB7),
    F64_CONVERT_I32_U             (NUMERIC,    NO_OPERAND,    (byte)0xB8),
    F64_CONVERT_I64_S             (NUMERIC,    NO_OPERAND,    (byte)0xB9),
    F64_CONVERT_I64_U             (NUMERIC,    NO_OPERAND,    (byte)0xBA),
    F64_PROMOTE_F32               (NUMERIC,    NO_OPERAND,    (byte)0xBB),
    I32_REINTERPRET_F32           (NUMERIC,    NO_OPERAND,    (byte)0xBC),
    I64_REINTERPRET_F64           (NUMERIC,    NO_OPERAND,    (byte)0xBD),
    F32_REINTERPRET_I32           (NUMERIC,    NO_OPERAND,    (byte)0xBE),
    F64_REINTERPRET_I64           (NUMERIC,    NO_OPERAND,    (byte)0xBF),
    I32_EXTEND8_S                 (NUMERIC,    NO_OPERAND,    (byte)0xC0),
    I32_EXTEND16_S                (NUMERIC,    NO_OPERAND,    (byte)0xC1),
    I64_EXTEND8_S                 (NUMERIC,    NO_OPERAND,    (byte)0xC2),
    I64_EXTEND16_S                (NUMERIC,    NO_OPERAND,    (byte)0xC3),
    I64_EXTEND32_S                (NUMERIC,    NO_OPERAND,    (byte)0xC4),
    I32_TRUNC_SAT_F32_S           (NUMERIC,    NO_OPERAND,    (byte)0xFC,   0),
    I32_TRUNC_SAT_F32_U           (NUMERIC,    NO_OPERAND,    (byte)0xFC,   1),
    I32_TRUNC_SAT_F64_S           (NUMERIC,    NO_OPERAND,    (byte)0xFC,   2),
    I32_TRUNC_SAT_F64_U           (NUMERIC,    NO_OPERAND,    (byte)0xFC,   3),
    I64_TRUNC_SAT_F32_S           (NUMERIC,    NO_OPERAND,    (byte)0xFC,   4),
    I64_TRUNC_SAT_F32_U           (NUMERIC,    NO_OPERAND,    (byte)0xFC,   5),
    I64_TRUNC_SAT_F64_S           (NUMERIC,    NO_OPERAND,    (byte)0xFC,   6),
    I64_TRUNC_SAT_F64_U           (NUMERIC,    NO_OPERAND,    (byte)0xFC,   7),

    // 2.4.2 Vector Instructions
    V128_LOAD                     (VECTOR,     INDEX_INDEX,   (byte)0xFD,   0),
    V128_LOAD8X8_S                (VECTOR,     INDEX_INDEX,   (byte)0xFD,   1),
    V128_LOAD8X8_U                (VECTOR,     INDEX_INDEX,   (byte)0xFD,   2),
    V128_LOAD16X4_S               (VECTOR,     INDEX_INDEX,   (byte)0xFD,   3),
    V128_LOAD16X4_U               (VECTOR,     INDEX_INDEX,   (byte)0xFD,   4),
    V128_LOAD32X2_S               (VECTOR,     INDEX_INDEX,   (byte)0xFD,   5),
    V128_LOAD32X2_U               (VECTOR,     INDEX_INDEX,   (byte)0xFD,   6),
    V128_LOAD8_SPLAT              (VECTOR,     INDEX_INDEX,   (byte)0xFD,   7),
    V128_LOAD16_SPLAT             (VECTOR,     INDEX_INDEX,   (byte)0xFD,   8),
    V128_LOAD32_SPLAT             (VECTOR,     INDEX_INDEX,   (byte)0xFD,   9),
    V128_LOAD64_SPLAT             (VECTOR,     INDEX_INDEX,   (byte)0xFD,  10),
    V128_LOAD32_ZERO              (VECTOR,     INDEX_INDEX,   (byte)0xFD,  92),
    V128_LOAD64_ZERO              (VECTOR,     INDEX_INDEX,   (byte)0xFD,  93),
    V128_STORE                    (VECTOR,     INDEX_INDEX,   (byte)0xFD,  11),
    V128_LOAD8_LANE               (VECTOR,     INDEXES,       (byte)0xFD,  84),
    V128_LOAD16_LANE              (VECTOR,     INDEXES,       (byte)0xFD,  85),
    V128_LOAD32_LANE              (VECTOR,     INDEXES,       (byte)0xFD,  86),
    V128_LOAD64_LANE              (VECTOR,     INDEXES,       (byte)0xFD,  87),
    V128_STORE8_LANE              (VECTOR,     INDEXES,       (byte)0xFD,  88),
    V128_STORE16_LANE             (VECTOR,     INDEXES,       (byte)0xFD,  89),
    V128_STORE32_LANE             (VECTOR,     INDEXES,       (byte)0xFD,  90),
    V128_STORE64_LANE             (VECTOR,     INDEXES,       (byte)0xFD,  91),
    V128_CONST                    (VECTOR,     CONST,         (byte)0xFD,  12),
    I8X16_SHUFFLE                 (VECTOR,     INDEXES,       (byte)0xFD,  13),
    I8X16_EXTRACT_LANE_S          (VECTOR,     INDEX,         (byte)0xFD,  21),
    I8X16_EXTRACT_LANE_U          (VECTOR,     INDEX,         (byte)0xFD,  22),
    I8X16_REPLACE_LANE            (VECTOR,     INDEX,         (byte)0xFD,  23),
    I16X8_EXTRACT_LANE_S          (VECTOR,     INDEX,         (byte)0xFD,  24),
    I16X8_EXTRACT_LANE_U          (VECTOR,     INDEX,         (byte)0xFD,  25),
    I16X8_REPLACE_LANE            (VECTOR,     INDEX,         (byte)0xFD,  26),
    I32X4_EXTRACT_LANE            (VECTOR,     INDEX,         (byte)0xFD,  27),
    I32X4_REPLACE_LANE            (VECTOR,     INDEX,         (byte)0xFD,  28),
    I64X2_EXTRACT_LANE            (VECTOR,     INDEX,         (byte)0xFD,  29),
    I64X2_REPLACE_LANE            (VECTOR,     INDEX,         (byte)0xFD,  30),
    F32X4_EXTRACT_LANE            (VECTOR,     INDEX,         (byte)0xFD,  31),
    F32X4_REPLACE_LANE            (VECTOR,     INDEX,         (byte)0xFD,  32),
    F64X2_EXTRACT_LANE            (VECTOR,     INDEX,         (byte)0xFD,  33),
    F64X2_REPLACE_LANE            (VECTOR,     INDEX,         (byte)0xFD,  34),
    I8X16_SWIZZLE                 (VECTOR,     NO_OPERAND,    (byte)0xFD,  14),
    I8X16_SPLAT                   (VECTOR,     NO_OPERAND,    (byte)0xFD,  15),
    I16X8_SPLAT                   (VECTOR,     NO_OPERAND,    (byte)0xFD,  16),
    I32X4_SPLAT                   (VECTOR,     NO_OPERAND,    (byte)0xFD,  17),
    I64X2_SPLAT                   (VECTOR,     NO_OPERAND,    (byte)0xFD,  18),
    F32X4_SPLAT                   (VECTOR,     NO_OPERAND,    (byte)0xFD,  19),
    F64X2_SPLAT                   (VECTOR,     NO_OPERAND,    (byte)0xFD,  20),
    I8X16_EQ                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  35),
    I8X16_NE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  36),
    I8X16_LT_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  37),
    I8X16_LT_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  38),
    I8X16_GT_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  39),
    I8X16_GT_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  40),
    I8X16_LE_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  41),
    I8X16_LE_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  42),
    I8X16_GE_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  43),
    I8X16_GE_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  44),
    I16X8_EQ                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  45),
    I16X8_NE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  46),
    I16X8_LT_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  47),
    I16X8_LT_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  48),
    I16X8_GT_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  49),
    I16X8_GT_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  50),
    I16X8_LE_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  51),
    I16X8_LE_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  52),
    I16X8_GE_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  53),
    I16X8_GE_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  54),
    I32X4_EQ                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  55),
    I32X4_NE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  56),
    I32X4_LT_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  57),
    I32X4_LT_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  58),
    I32X4_GT_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  59),
    I32X4_GT_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  60),
    I32X4_LE_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  61),
    I32X4_LE_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  62),
    I32X4_GE_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  63),
    I32X4_GE_U                    (VECTOR,     NO_OPERAND,    (byte)0xFD,  64),
    I64X2_EQ                      (VECTOR,     NO_OPERAND,    (byte)0xFD, 214),
    I64X2_NE                      (VECTOR,     NO_OPERAND,    (byte)0xFD, 215),
    I64X2_LT_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 216),
    I64X2_GT_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 217),
    I64X2_LE_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 218),
    I64X2_GE_S                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 219),
    F32X4_EQ                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  65),
    F32X4_NE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  66),
    F32X4_LT                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  67),
    F32X4_GT                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  68),
    F32X4_LE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  69),
    F32X4_GE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  70),
    F64X2_EQ                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  71),
    F64X2_NE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  72),
    F64X2_LT                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  73),
    F64X2_GT                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  74),
    F64X2_LE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  75),
    F64X2_GE                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  76),
    V128_NOT                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  77),
    V128_AND                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  78),
    V128_ANDNOT                   (VECTOR,     NO_OPERAND,    (byte)0xFD,  79),
    V128_OR                       (VECTOR,     NO_OPERAND,    (byte)0xFD,  80),
    V128_XOR                      (VECTOR,     NO_OPERAND,    (byte)0xFD,  81),
    V128_BITSELECT                (VECTOR,     NO_OPERAND,    (byte)0xFD,  82),
    V128_ANY_TRUE                 (VECTOR,     NO_OPERAND,    (byte)0xFD,  83),
    I8X16_ABS                     (VECTOR,     NO_OPERAND,    (byte)0xFD,  96),
    I8X16_NEG                     (VECTOR,     NO_OPERAND,    (byte)0xFD,  97),
    I8X16_POPCNT                  (VECTOR,     NO_OPERAND,    (byte)0xFD,  98),
    I8X16_ALL_TRUE                (VECTOR,     NO_OPERAND,    (byte)0xFD,  99),
    I8X16_BITMASK                 (VECTOR,     NO_OPERAND,    (byte)0xFD, 100),
    I8X16_NARROW_I16X8_S          (VECTOR,     NO_OPERAND,    (byte)0xFD, 101),
    I8X16_NARROW_I16X8_U          (VECTOR,     NO_OPERAND,    (byte)0xFD, 102),
    I8X16_SHL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 107),
    I8X16_SHR_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 108),
    I8X16_SHR_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 109),
    I8X16_ADD                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 110),
    I8X16_ADD_SAT_S               (VECTOR,     NO_OPERAND,    (byte)0xFD, 111),
    I8X16_ADD_SAT_U               (VECTOR,     NO_OPERAND,    (byte)0xFD, 112),
    I8X16_SUB                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 113),
    I8X16_SUB_SAT_S               (VECTOR,     NO_OPERAND,    (byte)0xFD, 114),
    I8X16_SUB_SAT_U               (VECTOR,     NO_OPERAND,    (byte)0xFD, 115),
    I8X16_MIN_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 118),
    I8X16_MIN_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 119),
    I8X16_MAX_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 120),
    I8X16_MAX_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 121),
    I8X16_AVGR_U                  (VECTOR,     NO_OPERAND,    (byte)0xFD, 123),
    I16X8_EXTADD_PAIRWISE_I8X16_S (VECTOR,     NO_OPERAND,    (byte)0xFD, 124),
    I16X8_EXTADD_PAIRWISE_I8X16_U (VECTOR,     NO_OPERAND,    (byte)0xFD, 125),
    I16X8_ABS                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 128),
    I16X8_NEG                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 129),
    I16X8_Q15MULR_SAT_S           (VECTOR,     NO_OPERAND,    (byte)0xFD, 130),
    I16X8_ALL_TRUE                (VECTOR,     NO_OPERAND,    (byte)0xFD, 131),
    I16X8_BITMASK                 (VECTOR,     NO_OPERAND,    (byte)0xFD, 132),
    I16X8_NARROW_I32X4_S          (VECTOR,     NO_OPERAND,    (byte)0xFD, 133),
    I16X8_NARROW_I32X4_U          (VECTOR,     NO_OPERAND,    (byte)0xFD, 134),
    I16X8_EXTEND_LOW_I8X16_S      (VECTOR,     NO_OPERAND,    (byte)0xFD, 135),
    I16X8_EXTEND_HIGH_I8X16_S     (VECTOR,     NO_OPERAND,    (byte)0xFD, 136),
    I16X8_EXTEND_LOW_I8X16_U      (VECTOR,     NO_OPERAND,    (byte)0xFD, 137),
    I16X8_EXTEND_HIGH_I8X16_U     (VECTOR,     NO_OPERAND,    (byte)0xFD, 138),
    I16X8_SHL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 139),
    I16X8_SHR_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 140),
    I16X8_SHR_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 141),
    I16X8_ADD                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 142),
    I16X8_ADD_SAT_S               (VECTOR,     NO_OPERAND,    (byte)0xFD, 143),
    I16X8_ADD_SAT_U               (VECTOR,     NO_OPERAND,    (byte)0xFD, 144),
    I16X8_SUB                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 145),
    I16X8_SUB_SAT_S               (VECTOR,     NO_OPERAND,    (byte)0xFD, 146),
    I16X8_SUB_SAT_U               (VECTOR,     NO_OPERAND,    (byte)0xFD, 147),
    I16X8_MUL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 149),
    I16X8_MIN_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 150),
    I16X8_MIN_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 151),
    I16X8_MAX_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 152),
    I16X8_MAX_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 153),
    I16X8_AVGR_U                  (VECTOR,     NO_OPERAND,    (byte)0xFD, 155),
    I16X8_EXTMUL_LOW_I8X16_S      (VECTOR,     NO_OPERAND,    (byte)0xFD, 156),
    I16X8_EXTMUL_HIGH_I8X16_S     (VECTOR,     NO_OPERAND,    (byte)0xFD, 157),
    I16X8_EXTMUL_LOW_I8X16_U      (VECTOR,     NO_OPERAND,    (byte)0xFD, 158),
    I16X8_EXTMUL_HIGH_I8X16_U     (VECTOR,     NO_OPERAND,    (byte)0xFD, 159),
    I32X4_EXTADD_PAIRWISE_I16X8_S (VECTOR,     NO_OPERAND,    (byte)0xFD, 126),
    I32X4_EXTADD_PAIRWISE_I16X8_U (VECTOR,     NO_OPERAND,    (byte)0xFD, 127),
    I32X4_ABS                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 160),
    I32X4_NEG                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 161),
    I32X4_ALL_TRUE                (VECTOR,     NO_OPERAND,    (byte)0xFD, 163),
    I32X4_BITMASK                 (VECTOR,     NO_OPERAND,    (byte)0xFD, 164),
    I32X4_EXTEND_LOW_I16X8_S      (VECTOR,     NO_OPERAND,    (byte)0xFD, 167),
    I32X4_EXTEND_HIGH_I16X8_S     (VECTOR,     NO_OPERAND,    (byte)0xFD, 168),
    I32X4_EXTEND_LOW_I16X8_U      (VECTOR,     NO_OPERAND,    (byte)0xFD, 169),
    I32X4_EXTEND_HIGH_I16X8_U     (VECTOR,     NO_OPERAND,    (byte)0xFD, 170),
    I32X4_SHL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 171),
    I32X4_SHR_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 172),
    I32X4_SHR_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 173),
    I32X4_ADD                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 174),
    I32X4_SUB                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 177),
    I32X4_MUL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 181),
    I32X4_MIN_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 182),
    I32X4_MIN_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 183),
    I32X4_MAX_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 184),
    I32X4_MAX_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 185),
    I32X4_DOT_I16X8_S             (VECTOR,     NO_OPERAND,    (byte)0xFD, 186),
    I32X4_EXTMUL_LOW_I16X8_S      (VECTOR,     NO_OPERAND,    (byte)0xFD, 188),
    I32X4_EXTMUL_HIGH_I16X8_S     (VECTOR,     NO_OPERAND,    (byte)0xFD, 189),
    I32X4_EXTMUL_LOW_I16X8_U      (VECTOR,     NO_OPERAND,    (byte)0xFD, 190),
    I32X4_EXTMUL_HIGH_I16X8_U     (VECTOR,     NO_OPERAND,    (byte)0xFD, 191),
    I64X2_ABS                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 192),
    I64X2_NEG                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 193),
    I64X2_ALL_TRUE                (VECTOR,     NO_OPERAND,    (byte)0xFD, 195),
    I64X2_BITMASK                 (VECTOR,     NO_OPERAND,    (byte)0xFD, 196),
    I64X2_EXTEND_LOW_I32X4_S      (VECTOR,     NO_OPERAND,    (byte)0xFD, 199),
    I64X2_EXTEND_HIGH_I32X4_S     (VECTOR,     NO_OPERAND,    (byte)0xFD, 200),
    I64X2_EXTEND_LOW_I32X4_U      (VECTOR,     NO_OPERAND,    (byte)0xFD, 201),
    I64X2_EXTEND_HIGH_I32X4_U     (VECTOR,     NO_OPERAND,    (byte)0xFD, 202),
    I64X2_SHL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 203),
    I64X2_SHR_S                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 204),
    I64X2_SHR_U                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 205),
    I64X2_ADD                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 206),
    I64X2_SUB                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 209),
    I64X2_MUL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 213),
    I64X2_EXTMUL_LOW_I32X4_S      (VECTOR,     NO_OPERAND,    (byte)0xFD, 220),
    I64X2_EXTMUL_HIGH_I32X4_S     (VECTOR,     NO_OPERAND,    (byte)0xFD, 221),
    I64X2_EXTMUL_LOW_I32X4_U      (VECTOR,     NO_OPERAND,    (byte)0xFD, 222),
    I64X2_EXTMUL_HIGH_I32X4_U     (VECTOR,     NO_OPERAND,    (byte)0xFD, 223),
    F32X4_CEIL                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 103),
    F32X4_FLOOR                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 104),
    F32X4_TRUNC                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 105),
    F32X4_NEAREST                 (VECTOR,     NO_OPERAND,    (byte)0xFD, 106),
    F32X4_ABS                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 224),
    F32X4_NEG                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 225),
    F32X4_SQRT                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 227),
    F32X4_ADD                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 228),
    F32X4_SUB                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 229),
    F32X4_MUL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 230),
    F32X4_DIV                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 231),
    F32X4_MIN                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 232),
    F32X4_MAX                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 233),
    F32X4_PMIN                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 234),
    F32X4_PMAX                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 235),
    F64X2_CEIL                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 116),
    F64X2_FLOOR                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 117),
    F64X2_TRUNC                   (VECTOR,     NO_OPERAND,    (byte)0xFD, 122),
    F64X2_NEAREST                 (VECTOR,     NO_OPERAND,    (byte)0xFD, 148),
    F64X2_ABS                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 236),
    F64X2_NEG                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 237),
    F64X2_SQRT                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 239),
    F64X2_ADD                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 240),
    F64X2_SUB                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 241),
    F64X2_MUL                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 242),
    F64X2_DIV                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 243),
    F64X2_MIN                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 244),
    F64X2_MAX                     (VECTOR,     NO_OPERAND,    (byte)0xFD, 245),
    F64X2_PMIN                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 246),
    F64X2_PMAX                    (VECTOR,     NO_OPERAND,    (byte)0xFD, 247),
    I32X4_TRUNC_SAT_F32X4_S       (VECTOR,     NO_OPERAND,    (byte)0xFD, 248),
    I32X4_TRUNC_SAT_F32X4_U       (VECTOR,     NO_OPERAND,    (byte)0xFD, 249),
    F32X4_CONVERT_I32X4_S         (VECTOR,     NO_OPERAND,    (byte)0xFD, 250),
    F32X4_CONVERT_I32X4_U         (VECTOR,     NO_OPERAND,    (byte)0xFD, 251),
    I32X4_TRUNC_SAT_F64X2_S_ZERO  (VECTOR,     NO_OPERAND,    (byte)0xFD, 252),
    I32X4_TRUNC_SAT_F64X2_U_ZERO  (VECTOR,     NO_OPERAND,    (byte)0xFD, 253),
    F64X2_CONVERT_LOW_I32X4_S     (VECTOR,     NO_OPERAND,    (byte)0xFD, 254),
    F64X2_CONVERT_LOW_I32X4_U     (VECTOR,     NO_OPERAND,    (byte)0xFD, 255),
    F32X4_DEMOTE_F64X2_ZERO       (VECTOR,     NO_OPERAND,    (byte)0xFD,  94),
    F64X2_PROMOTE_LOW_F32X4       (VECTOR,     NO_OPERAND,    (byte)0xFD,  95),
    // @formatter:on
    ;
    private final InstructionGroup group;
    private final OpCodeType type;

    OpCode(InstructionGroup group, OpCodeType type, byte code) {
        this.group = group;
        this.type = type;
    }

    OpCode(InstructionGroup group, OpCodeType type, byte prefix, int code) {
        this.group = group;
        this.type = type;
    }

    public InstructionGroup getGroup() {
        return group;
    }

    public OpCodeType getType() {
        return type;
    }
}