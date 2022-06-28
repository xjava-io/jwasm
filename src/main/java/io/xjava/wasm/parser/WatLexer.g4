/*
 * Copyright 2022 xjava.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
lexer grammar WatLexer;

@header {
package io.xjava.wasm.parser;
}

// Tokens
LEFT_PAREN          : '('                                   ;
RIGHT_PAREN         : ')'                                   ;

INTEGER             : Sign? Num | Sign? '0x' HexNum         ;
FLOAT               : Sign? FloatMag                        ;
STRING              : '"' StringElem* '"'                   ;
ID                  : '$' IdChar+                           ;

// Types
NUM_TYPE            : INT_TYPE | FLOAT_TYPE                 ;
VEC_TYPE            : 'v128'                                ;
REF_TYPE            : 'funcref' | 'externref'               ;
VEC_SHAPE           : I_SHAPE | F_SHAPE                     ;

// Memory Instructions
NUM_LOAD            : NUM_TYPE '.load'
                    | INT_TYPE '.load8'  SX
                    | INT_TYPE '.load16' SX
                    | 'i64.load32'       SX                 ;
NUM_STORE           : NUM_TYPE '.store'
                    | INT_TYPE '.store8'
                    | INT_TYPE '.store16'
                    | 'i64.store32'                         ;
VEC_LOAD            : 'v128.load'
                    | 'v128.load8x8'  SX
                    | 'v128.load16x4' SX
                    | 'v128.load32x2' SX
                    | 'v128.load32_zero'
                    | 'v128.load64_zero'
                    | 'v128.load' WW '_splat'               ;
VEC_LOAD_LANE       : 'v128.load' WW '_lane'                ;
VEC_STORE           : 'v128.store'                          ;
VEC_STORE_LANE      : 'v128.store' WW '_lane'               ;

MEM_OFFSET          : 'offset=' INTEGER                     ;
MEM_ALIGN           : 'align='  INTEGER                     ;

// Numeric Instructions
INT_CONST           : INT_TYPE '.const'                     ;
FLOAT_CONST         : FLOAT_TYPE '.const'                   ;
NUM_INSTR           : INT_TYPE '.' I_UN_OP
                    | INT_TYPE '.' I_BIN_OP
                    | INT_TYPE '.' I_TEST_OP
                    | INT_TYPE '.' I_REL_OP
                    | FLOAT_TYPE '.' F_UN_OP
                    | FLOAT_TYPE '.' F_BIN_OP
                    | FLOAT_TYPE '.' F_REL_OP
                    | INT_TYPE '.extend8_s'
                    | INT_TYPE '.extend16_s'
                    | 'i64.extend32_s'
                    | 'i32.wrap_i64'
                    | 'i64.extend_i32' SX
                    | INT_TYPE '.trunc_' FLOAT_TYPE SX
                    | INT_TYPE '.trunc_sat_' FLOAT_TYPE SX
                    | 'f32.demote_f64'
                    | 'f64.promote_f32'
                    | FLOAT_TYPE '.convert_' INT_TYPE SX
                    | INT_TYPE   '.reinterpret_' FLOAT_TYPE
                    | FLOAT_TYPE '.reinterpret_' INT_TYPE   ;

// Vector Instructions
VEC_CONST           : 'v128.const'                          ;
VEC_SHUFFLE         : 'i8x16.shuffle'                       ;
VEC_LANE_INSTR      : 'i8x16.extract_lane' SX
                    | 'i16x8.extract_lane' SX
                    | 'i32x4.extract_lane'
                    | 'i64x2.extract_lane'
                    | F_SHAPE '.extract_lane'
                    | VEC_SHAPE   '.replace_lane'           ;
VEC_INSTR           : 'v128.' V_V_UN_OP
                    | 'v128.' V_V_BIN_OP
                    | 'v128.' V_V_TERN_OP
                    | 'v128.' V_V_TEST_OP
                    | 'i8x16.swizzle'
                    | VEC_SHAPE '.splat'
                    | 'i8x16.' V_I_REL_OP
                    | 'i16x8.' V_I_REL_OP
                    | 'i32x4.' V_I_REL_OP
                    | 'i64x2.eq'
                    | 'i64x2.ne'
                    | 'i64x2.lt_s'
                    | 'i64x2.gt_s'
                    | 'i64x2.le_s'
                    | 'i64x2.ge_s'
                    | F_SHAPE '.' V_F_REL_OP
                    | I_SHAPE '.' V_I_UN_OP
                    | 'i8x16.popcnt'
                    | 'i16x8.q15mulr_sat_s'
                    | 'i32x4.dot_i16x8_s'
                    | F_SHAPE '.' V_F_UN_OP
                    | I_SHAPE '.' V_I_TEST_OP
                    | I_SHAPE '.bitmask'
                    | 'i8x16.narrow_i16x8' SX
                    | 'i16x8.narrow_i32x4' SX
                    | 'i16x8.extend_' HALF '_i8x16' SX
                    | 'i32x4.extend_' HALF '_i16x8' SX
                    | 'i64x2.extend_' HALF '_i32x4' SX
                    | I_SHAPE '.' V_I_SHIFT_OP
                    | I_SHAPE '.' V_I_BIN_OP
                    | 'i8x16.' V_I_MIN_MAX_OP
                    | 'i16x8.' V_I_MIN_MAX_OP
                    | 'i32x4.' V_I_MIN_MAX_OP
                    | 'i8x16.' V_I_SAT_BIN_OP
                    | 'i16x8.' V_I_SAT_BIN_OP
                    | 'i16x8.mul'
                    | 'i32x4.mul'
                    | 'i64x2.mul'
                    | 'i8x16.avgr_u'
                    | 'i16x8.avgr_u'
                    | 'i16x8.extmul_' HALF '_i8x16' SX
                    | 'i32x4.extmul_' HALF '_i16x8' SX
                    | 'i64x2.extmul_' HALF '_i32x4' SX
                    | 'i16x8.extadd_pairwise_i8x16' SX
                    | 'i32x4.extadd_pairwise_i16x8' SX
                    | F_SHAPE '.' V_F_BIN_OP
                    | 'i32x4.trunc_sat_f32x4' SX
                    | 'i32x4.trunc_sat_f64x2' SX '_zero'
                    | 'f32x4.convert_i32x4' SX
                    | 'f32x4.demote_f64x2_zero'
                    | 'f64x2.convert_low_i32x4' SX
                    | 'f64x2.promote_low_f32x4'             ;

// Other Instructions
BLOCK               : 'block'                               ;
BR                  : 'br'                                  ;
BR_IF               : 'br_if'                               ;
BR_TABLE            : 'br_table'                            ;
CALL                : 'call'                                ;
CALL_INDIRECT       : 'call_indirect'                       ;
DATA                : 'data'                                ;
DATA_DROP           : 'data.drop'                           ;
DECLARE             : 'declare'                             ;
DROP                : 'drop'                                ;
ELEM                : 'elem'                                ;
ELEM_DROP           : 'elem.drop'                           ;
ELSE                : 'else'                                ;
END                 : 'end'                                 ;
EXPORT              : 'export'                              ;
EXTERN              : 'extern'                              ;
FUNC                : 'func'                                ;
GLOBAL              : 'global'                              ;
GLOBAL_GET          : 'global.get'                          ;
GLOBAL_SET          : 'global.set'                          ;
IF                  : 'if'                                  ;
IMPORT              : 'import'                              ;
ITEM                : 'item'                                ;
LOCAL               : 'local'                               ;
LOCAL_GET           : 'local.get'                           ;
LOCAL_SET           : 'local.set'                           ;
LOCAL_TEE           : 'local.tee'                           ;
LOOP                : 'loop'                                ;
MEMORY              : 'memory'                              ;
MEMORY_COPY         : 'memory.copy'                         ;
MEMORY_FILL         : 'memory.fill'                         ;
MEMORY_GROW         : 'memory.grow'                         ;
MEMORY_INIT         : 'memory.init'                         ;
MEMORY_SIZE         : 'memory.size'                         ;
MODULE              : 'module'                              ;
MUT                 : 'mut'                                 ;
NOP                 : 'nop'                                 ;
OFFSET              : 'offset'                              ;
PARAM               : 'param'                               ;
REF_FUNC            : 'ref.func'                            ;
REF_IS_NULL         : 'ref.is_null'                         ;
REF_NULL            : 'ref.null'                            ;
RESULT              : 'result'                              ;
RETURN              : 'return'                              ;
SELECT              : 'select'                              ;
START               : 'start'                               ;
TABLE               : 'table'                               ;
TABLE_COPY          : 'table.copy'                          ;
TABLE_FILL          : 'table.fill'                          ;
TABLE_GET           : 'table.get'                           ;
TABLE_GROW          : 'table.grow'                          ;
TABLE_INIT          : 'table.init'                          ;
TABLE_SET           : 'table.set'                           ;
TABLE_SIZE          : 'table.size'                          ;
THEN                : 'then'                                ;
TYPE                : 'type'                                ;
UNREACHABLE         : 'unreachable'                         ;

// Script Tokens
ASSERT_EXHAUSTION   : 'assert_exhaustion'                   ;
ASSERT_INVALID      : 'assert_invalid'                      ;
ASSERT_MALFORMED    : 'assert_malformed'                    ;
ASSERT_RETURN       : 'assert_return'                       ;
ASSERT_TRAP         : 'assert_trap'                         ;
ASSERT_UNLINKABLE   : 'assert_unlinkable'                   ;
BINARY              : 'binary'                              ;
GET                 : 'get'                                 ;
INPUT               : 'input'                               ;
INVOKE              : 'invoke'                              ;
NAN_ARITHMETIC      : 'nan:arithmetic'                      ;
NAN_CANONICAL       : 'nan:canonical'                       ;
OUTPUT              : 'output'                              ;
QUOTE               : 'quote'                               ;
REF_EXTERN          : 'ref.extern'                          ;
REGISTER            : 'register'                            ;
SCRIPT              : 'script'                              ;

// Integers
fragment Sign       : '+' | '-'                             ;
fragment Digit      : [0-9]                                 ;
fragment HexDigit   : [0-9a-fA-F]                           ;
fragment Num        : Digit ('_'? Digit)*                   ;
fragment HexNum     : HexDigit ('_'? HexDigit)*             ;

// Floating-Point
fragment Frac       : Num                                   ;
fragment HexFrac    : HexNum                                ;
fragment Float      : Num '.'?
                    | Num '.' Frac
                    | Num '.'?     [Ee] Sign? Num
                    | Num '.' Frac [Ee] Sign? Num           ;
fragment HexFloat   : '0x' HexNum '.'?
                    | '0x' HexNum '.' HexFrac
                    | '0x' HexNum '.'?        [Pp] Sign? Num
                    | '0x' HexNum '.' HexFrac [Pp] Sign? Num;
fragment FloatMag   : Float
                    | HexFloat
                    | 'inf'
                    | 'nan'
                    | 'nan:' '0x' HexNum                    ;
// Strings
fragment StringElem : StringChar
                    | '\\' HexDigit HexDigit                ;
fragment StringChar : ~[\u0000-\u001f\u007F"\\]
                    | '\\t'
                    | '\\n'
                    | '\\r'
                    | '\\"'
                    | '\\\''
                    | '\\\\'
                    | '\\u{' HexDigit+ '}'                  ;

// Identifiers
fragment IdChar     : [0-9a-zA-Z!#$%&′*+\-./:<=>?@∖^_`|~]   ;

// Number Types
fragment INT_TYPE   : 'i32' | 'i64'                         ;
fragment FLOAT_TYPE : 'f32' | 'f64'                         ;
fragment SX         : '_u'  | '_s'                          ;

// Vec Shapes
fragment I_SHAPE    : 'i8x16' | 'i16x8' | 'i32x4' | 'i64x2' ;
fragment F_SHAPE    :                     'f32x4' | 'f64x2' ;

fragment HALF       : 'low' | 'high'                        ;
fragment WW         : '8' | '16' | '32' | '64'              ;

// Number Operators
fragment I_UN_OP    : 'clz'
                    | 'ctz'
                    | 'popcnt'                              ;
fragment I_BIN_OP   : 'add'
                    | 'sub'
                    | 'mul'
                    | 'div' SX
                    | 'rem' SX
                    | 'and'
                    | 'or'
                    | 'xor'
                    | 'shl'
                    | 'shr' SX
                    | 'rotl'
                    | 'rotr'                                ;
fragment F_UN_OP    : 'abs'
                    | 'neg'
                    | 'sqrt'
                    | 'ceil'
                    | 'floor'
                    | 'trunc'
                    | 'nearest'                             ;
fragment F_BIN_OP   : 'add'
                    | 'sub'
                    | 'mul'
                    | 'div'
                    | 'min'
                    | 'max'
                    | 'copysign'                            ;
fragment I_TEST_OP  : 'eqz'                                 ;
fragment I_REL_OP   : 'eq'
                    | 'ne'
                    | 'lt' SX
                    | 'gt' SX
                    | 'le' SX
                    | 'ge' SX                               ;
fragment F_REL_OP   : 'eq'
                    | 'ne'
                    | 'lt'
                    | 'gt'
                    | 'le'
                    | 'ge'                                  ;

// Vector Operators
fragment V_V_UN_OP  : 'not'                                 ;
fragment V_V_BIN_OP : 'and'
                    | 'andnot'
                    | 'or'
                    | 'xor'                                 ;
fragment V_V_TERN_OP: 'bitselect'                           ;
fragment V_V_TEST_OP: 'any_true'                            ;
fragment V_I_TEST_OP: 'all_true'                            ;
fragment V_I_REL_OP : 'eq'
                    | 'ne'
                    | 'lt' SX
                    | 'gt' SX
                    | 'le' SX
                    | 'ge' SX                               ;
fragment V_F_REL_OP : 'eq'
                    | 'ne'
                    | 'lt'
                    | 'gt'
                    | 'le'
                    | 'ge'                                  ;
fragment V_I_UN_OP  : 'abs'
                    | 'neg'                                 ;
fragment V_I_BIN_OP : 'add'
                    | 'sub'                                 ;
fragment V_I_MIN_MAX_OP
                    : 'min' SX
                    | 'max' SX                              ;
fragment V_I_SAT_BIN_OP
                    : 'add_sat' SX
                    | 'sub_sat' SX                          ;
fragment V_I_SHIFT_OP
                    : 'shl'
                    | 'shr' SX                              ;
fragment V_F_UN_OP  : 'abs'
                    | 'neg'
                    | 'sqrt'
                    | 'ceil'
                    | 'floor'
                    | 'trunc'
                    | 'nearest'                             ;
fragment V_F_BIN_OP : 'add'
                    | 'sub'
                    | 'mul'
                    | 'div'
                    | 'min'
                    | 'max'
                    | 'pmin'
                    | 'pmax'                                ;

// Skip
SPACE               : [ \t\n\r]                     -> skip ;

LINE_COMMENT        : ';;' .*? ( '\n' | EOF )       -> skip ;
BLOCK_COMMENT       : COMMENT                       -> skip ;
fragment COMMENT    : '(;' BLOCK_CHAR* ';)'                 ;
fragment BLOCK_CHAR : ~[;(] | ';' ~[(] | '(' ~[;] | COMMENT ;