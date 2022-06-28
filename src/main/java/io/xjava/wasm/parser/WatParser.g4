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
parser grammar WatParser;

@header {
package io.xjava.wasm.parser;
}

options { tokenVocab=WatLexer; }

// Values
id              : ID                                                        ;

index           : ID | INTEGER                                              ;
typeIndex       : index                                                     ;
functionIndex   : index                                                     ;
tableIndex      : index                                                     ;
memoryIndex     : index                                                     ;
globalIndex     : index                                                     ;
elementIndex    : index                                                     ;
dataIndex       : index                                                     ;
localIndex      : index                                                     ;
labelIndex      : index                                                     ;

name            : STRING                                                    ;
dataString      : STRING*                                                   ;

number          : INTEGER | FLOAT                                           ;

// Types
refType         : REF_TYPE                                                  ;
heapType        : 'func'   | 'extern'                                       ;
valueType       : NUM_TYPE | VEC_TYPE | REF_TYPE                            ;
vecType         : VEC_TYPE                                                  ;
vecShape        : VEC_SHAPE                                                 ;

funcType        : '(' 'func'    param*         result*        ')'           ;
result          : '(' 'result'  valueType*                    ')'           ;
param           : '(' 'param'   ( valueType* | id valueType ) ')'           ;
local           : '(' 'local'   ( valueType* | id valueType ) ')'           ;

memType         : INTEGER INTEGER?                                          ;
tableType       : INTEGER INTEGER? refType                                  ;
globalType      : valueType | '(' 'mut' valueType ')'                       ;

// Instructions
label           : ID?                                                       ;
blockType       : result?
                | typeUse                                                   ;
memArg          : MEM_OFFSET? MEM_ALIGN?                                    ;

blockInstr      : 'block' label blockType expr 'end'  id?
                | 'loop'  label blockType expr 'end'  id?
                | 'if'    label blockType expr 'end'  id?
                | 'if'    label blockType expr 'else' id? expr 'end' id?    ;
plainInstr      : controlInstr
                | referenceInstr
                | parametricInstr
                | variableInstr
                | tableInstr
                | memoryInstr
                | numericInstr
                | vectorInstr                                               ;
controlInstr    : 'unreachable'
                | 'nop'
                | 'br'            labelIndex
                | 'br_if'         labelIndex
                | 'br_table'      labelIndex+
                | 'return'
                | 'call'          functionIndex
                | 'call_indirect' tableIndex?   typeUse                     ;
referenceInstr  : 'ref.null'      heapType
                | 'ref.is_null'
                | 'ref.func'      functionIndex                             ;
parametricInstr : 'drop'
                | 'select'        result*                                   ;
variableInstr   : 'local.get'     localIndex
                | 'local.set'     localIndex
                | 'local.tee'     localIndex
                | 'global.get'    globalIndex
                | 'global.set'    globalIndex                               ;
tableInstr      : 'table.get'     tableIndex?
                | 'table.set'     tableIndex?
                | 'table.size'    tableIndex?
                | 'table.grow'    tableIndex?
                | 'table.fill'    tableIndex?
                | 'table.copy'    (tableIndex tableIndex)?
                | 'table.init'    tableIndex? elementIndex
                | 'elem.drop'     elementIndex                              ;
memoryInstr     : NUM_LOAD        memArg
                | NUM_STORE       memArg
                | VEC_LOAD        memArg
                | VEC_STORE       memArg
                | VEC_LOAD_LANE   memArg INTEGER
                | VEC_STORE_LANE  memArg INTEGER
                | 'memory.size'
                | 'memory.grow'
                | 'memory.fill'
                | 'memory.copy'
                | 'memory.init'   dataIndex
                | 'data.drop'     dataIndex                                 ;
numericInstr    : INT_CONST       INTEGER
                | FLOAT_CONST     number
                | NUM_INSTR                                                 ;
vectorInstr     : VEC_CONST vecShape number+
                | 'i8x16.shuffle'    INTEGER+
                | VEC_LANE_INSTR     INTEGER
                | VEC_INSTR                                                 ;
instr           : plainInstr
                | blockInstr
                | '(' blockInstr ')'
                | '(' plainInstr expr                 ')'
                | '(' 'block'    label blockType expr ')'
                | '(' 'loop'     label blockType expr ')'
                | '(' 'if'       label blockType expr
                  '(' 'then'     expr ')' ( '(' 'else'  expr ')' )? ')'     ;

expr            : instr*                                                    ;

// Modules
module          : '(' 'module'  id?  moduleField*  ')' EOF
                |                    moduleField*      EOF                  ;

moduleField     : type
                | moduleImport
                | func
                | table
                | mem
                | global
                | moduleExport
                | start
                | elem
                | data                                                      ;

// ModuleFields
type            : '(' 'type'    id?   funcType                         ')'  ;
func            : '(' 'func'    id?   funcDesc                         ')'  ;
table           : '(' 'table'   id?   tableDesc                        ')'  ;
mem             : '(' 'memory'  id?   memDesc                          ')'  ;
global          : '(' 'global'  id?   globalDesc                       ')'  ;
moduleImport    : '(' 'import'  name  name       importDesc            ')'  ;
moduleExport    : '(' 'export'  name             exportDesc            ')'  ;
start           : '(' 'start'   functionIndex                          ')'  ;
elem            : '(' 'elem'    id?                     elemList       ')'
                | '(' 'elem'    id?   tableUse?  offset elemList       ')'
                | '(' 'elem'    id?              offset functionIndex* ')'
                | '(' 'elem'    id?   'declare'         elemList       ')'  ;
data            : '(' 'data'    id?                     dataString     ')'
                | '(' 'data'    id?   memUse?    offset dataString     ')'  ;

offset          : '(' 'offset'  expr        ')'  |  instr                   ;
item            : '(' 'item'    expr        ')'  |  instr                   ;
inlineImport    : '(' 'import'  name  name  ')'                             ;
inlineExport    : '(' 'export'  name        ')'                             ;
memUse          : '(' 'memory'  memoryIndex ')'                             ;
tableUse        : '(' 'table'   tableIndex  ')'                             ;
typeUse         : '(' 'type'    typeIndex   ')'  param*  result*
                |                                param*  result*            ;

funcDesc        :               typeUse    local*   expr
                | inlineImport  typeUse
                | inlineExport  funcDesc                                    ;
tableDesc       :               tableType
                | inlineImport  tableType
                | inlineExport  tableDesc
                | refType       '('        'elem'   item*           ')'
                | refType       '('        'elem'   functionIndex*  ')'     ;
memDesc         :               memType
                | inlineImport  memType
                | inlineExport  memDesc
                | '(' 'data'    dataString                  ')'             ;
globalDesc      :               globalType expr
                | inlineImport  globalType
                | inlineExport  globalDesc                                  ;
importDesc      : '(' 'func'    id?        typeUse          ')'
                | '(' 'global'  id?        globalType       ')'
                | '(' 'table'   id?        tableType        ')'
                | '(' 'memory'  id?        memType          ')'             ;
exportDesc      : '(' 'func'    functionIndex               ')'
                | '(' 'global'  globalIndex                 ')'
                | '(' 'table'   tableIndex                  ')'
                | '(' 'memory'  memoryIndex                 ')'             ;
elemList        : refType       item*
                | 'func'        functionIndex*                              ;

// Scripts
script          : command*      EOF
                | moduleField*  EOF                                         ;
command         : scriptModule
                | register
                | action
                | assertion
                | meta                                                      ;

scriptModule    : '(' 'module'  id?  moduleField*          ')'
                | '(' 'module'  id? 'binary'  dataString   ')'
                | '(' 'module'  id? 'quote'   dataString   ')'              ;
action          : '(' 'invoke'  id?  name     scriptConst* ')'
                | '(' 'get'     id?  name                  ')'              ;
register        : '(' 'register'     name     id?          ')'              ;
scriptConst     : '(' INT_CONST      INTEGER               ')'
                | '(' FLOAT_CONST    number                ')'
                | '(' VEC_CONST      vecShape number+      ')'
                | '(' 'ref.null'     heapType              ')'
                | '(' 'ref.extern'   INTEGER               ')'              ;
assertion       : '(' 'assert_return'     action       scriptResult* ')'
                | '(' 'assert_trap'       action       dataString    ')'
                | '(' 'assert_exhaustion' action       dataString    ')'
                | '(' 'assert_malformed'  scriptModule dataString    ')'
                | '(' 'assert_invalid'    scriptModule dataString    ')'
                | '(' 'assert_unlinkable' scriptModule dataString    ')'
                | '(' 'assert_trap'       scriptModule dataString    ')'    ;
scriptResult    : scriptConst
                | '(' INT_CONST    numPat           ')'
                | '(' FLOAT_CONST  numPat           ')'
                | '(' VEC_CONST    vecShape numPat+ ')'
                | '(' 'ref.extern'                  ')'
                | '(' 'ref.func'                    ')'                     ;
numPat          : number
                | 'nan:canonical'
                | 'nan:arithmetic'                                          ;
meta            : '(' 'script' id? script  ')'
                | '(' 'input'  id? script  ')'
                | '(' 'output' id? script? ')'                              ;