// Generated from WatParser.g4 by ANTLR 4.9.3

package io.xjava.wasm.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WatParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_PAREN=1, RIGHT_PAREN=2, INTEGER=3, FLOAT=4, STRING=5, ID=6, NUM_TYPE=7, 
		VEC_TYPE=8, REF_TYPE=9, VEC_SHAPE=10, NUM_LOAD=11, NUM_STORE=12, VEC_LOAD=13, 
		VEC_LOAD_LANE=14, VEC_STORE=15, VEC_STORE_LANE=16, MEM_OFFSET=17, MEM_ALIGN=18, 
		INT_CONST=19, FLOAT_CONST=20, NUM_INSTR=21, VEC_CONST=22, VEC_SHUFFLE=23, 
		VEC_LANE_INSTR=24, VEC_INSTR=25, BLOCK=26, BR=27, BR_IF=28, BR_TABLE=29, 
		CALL=30, CALL_INDIRECT=31, DATA=32, DATA_DROP=33, DECLARE=34, DROP=35, 
		ELEM=36, ELEM_DROP=37, ELSE=38, END=39, EXPORT=40, EXTERN=41, FUNC=42, 
		GLOBAL=43, GLOBAL_GET=44, GLOBAL_SET=45, IF=46, IMPORT=47, ITEM=48, LOCAL=49, 
		LOCAL_GET=50, LOCAL_SET=51, LOCAL_TEE=52, LOOP=53, MEMORY=54, MEMORY_COPY=55, 
		MEMORY_FILL=56, MEMORY_GROW=57, MEMORY_INIT=58, MEMORY_SIZE=59, MODULE=60, 
		MUT=61, NOP=62, OFFSET=63, PARAM=64, REF_FUNC=65, REF_IS_NULL=66, REF_NULL=67, 
		RESULT=68, RETURN=69, SELECT=70, START=71, TABLE=72, TABLE_COPY=73, TABLE_FILL=74, 
		TABLE_GET=75, TABLE_GROW=76, TABLE_INIT=77, TABLE_SET=78, TABLE_SIZE=79, 
		THEN=80, TYPE=81, UNREACHABLE=82, ASSERT_EXHAUSTION=83, ASSERT_INVALID=84, 
		ASSERT_MALFORMED=85, ASSERT_RETURN=86, ASSERT_TRAP=87, ASSERT_UNLINKABLE=88, 
		BINARY=89, GET=90, INPUT=91, INVOKE=92, NAN_ARITHMETIC=93, NAN_CANONICAL=94, 
		OUTPUT=95, QUOTE=96, REF_EXTERN=97, REGISTER=98, SCRIPT=99, SPACE=100, 
		LINE_COMMENT=101, BLOCK_COMMENT=102;
	public static final int
		RULE_id = 0, RULE_index = 1, RULE_typeIndex = 2, RULE_functionIndex = 3, 
		RULE_tableIndex = 4, RULE_memoryIndex = 5, RULE_globalIndex = 6, RULE_elementIndex = 7, 
		RULE_dataIndex = 8, RULE_localIndex = 9, RULE_labelIndex = 10, RULE_name = 11, 
		RULE_dataString = 12, RULE_number = 13, RULE_refType = 14, RULE_heapType = 15, 
		RULE_valueType = 16, RULE_vecType = 17, RULE_vecShape = 18, RULE_funcType = 19, 
		RULE_result = 20, RULE_param = 21, RULE_local = 22, RULE_memType = 23, 
		RULE_tableType = 24, RULE_globalType = 25, RULE_label = 26, RULE_blockType = 27, 
		RULE_memArg = 28, RULE_blockInstr = 29, RULE_plainInstr = 30, RULE_controlInstr = 31, 
		RULE_referenceInstr = 32, RULE_parametricInstr = 33, RULE_variableInstr = 34, 
		RULE_tableInstr = 35, RULE_memoryInstr = 36, RULE_numericInstr = 37, RULE_vectorInstr = 38, 
		RULE_instr = 39, RULE_expr = 40, RULE_module = 41, RULE_moduleField = 42, 
		RULE_type = 43, RULE_func = 44, RULE_table = 45, RULE_mem = 46, RULE_global = 47, 
		RULE_moduleImport = 48, RULE_moduleExport = 49, RULE_start = 50, RULE_elem = 51, 
		RULE_data = 52, RULE_offset = 53, RULE_item = 54, RULE_inlineImport = 55, 
		RULE_inlineExport = 56, RULE_memUse = 57, RULE_tableUse = 58, RULE_typeUse = 59, 
		RULE_funcDesc = 60, RULE_tableDesc = 61, RULE_memDesc = 62, RULE_globalDesc = 63, 
		RULE_importDesc = 64, RULE_exportDesc = 65, RULE_elemList = 66, RULE_script = 67, 
		RULE_command = 68, RULE_scriptModule = 69, RULE_action = 70, RULE_register = 71, 
		RULE_scriptConst = 72, RULE_assertion = 73, RULE_scriptResult = 74, RULE_numPat = 75, 
		RULE_meta = 76;
	private static String[] makeRuleNames() {
		return new String[] {
			"id", "index", "typeIndex", "functionIndex", "tableIndex", "memoryIndex", 
			"globalIndex", "elementIndex", "dataIndex", "localIndex", "labelIndex", 
			"name", "dataString", "number", "refType", "heapType", "valueType", "vecType", 
			"vecShape", "funcType", "result", "param", "local", "memType", "tableType", 
			"globalType", "label", "blockType", "memArg", "blockInstr", "plainInstr", 
			"controlInstr", "referenceInstr", "parametricInstr", "variableInstr", 
			"tableInstr", "memoryInstr", "numericInstr", "vectorInstr", "instr", 
			"expr", "module", "moduleField", "type", "func", "table", "mem", "global", 
			"moduleImport", "moduleExport", "start", "elem", "data", "offset", "item", 
			"inlineImport", "inlineExport", "memUse", "tableUse", "typeUse", "funcDesc", 
			"tableDesc", "memDesc", "globalDesc", "importDesc", "exportDesc", "elemList", 
			"script", "command", "scriptModule", "action", "register", "scriptConst", 
			"assertion", "scriptResult", "numPat", "meta"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, null, null, null, null, "'v128'", null, null, 
			null, null, null, null, "'v128.store'", null, null, null, null, null, 
			null, "'v128.const'", "'i8x16.shuffle'", null, null, "'block'", "'br'", 
			"'br_if'", "'br_table'", "'call'", "'call_indirect'", "'data'", "'data.drop'", 
			"'declare'", "'drop'", "'elem'", "'elem.drop'", "'else'", "'end'", "'export'", 
			"'extern'", "'func'", "'global'", "'global.get'", "'global.set'", "'if'", 
			"'import'", "'item'", "'local'", "'local.get'", "'local.set'", "'local.tee'", 
			"'loop'", "'memory'", "'memory.copy'", "'memory.fill'", "'memory.grow'", 
			"'memory.init'", "'memory.size'", "'module'", "'mut'", "'nop'", "'offset'", 
			"'param'", "'ref.func'", "'ref.is_null'", "'ref.null'", "'result'", "'return'", 
			"'select'", "'start'", "'table'", "'table.copy'", "'table.fill'", "'table.get'", 
			"'table.grow'", "'table.init'", "'table.set'", "'table.size'", "'then'", 
			"'type'", "'unreachable'", "'assert_exhaustion'", "'assert_invalid'", 
			"'assert_malformed'", "'assert_return'", "'assert_trap'", "'assert_unlinkable'", 
			"'binary'", "'get'", "'input'", "'invoke'", "'nan:arithmetic'", "'nan:canonical'", 
			"'output'", "'quote'", "'ref.extern'", "'register'", "'script'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LEFT_PAREN", "RIGHT_PAREN", "INTEGER", "FLOAT", "STRING", "ID", 
			"NUM_TYPE", "VEC_TYPE", "REF_TYPE", "VEC_SHAPE", "NUM_LOAD", "NUM_STORE", 
			"VEC_LOAD", "VEC_LOAD_LANE", "VEC_STORE", "VEC_STORE_LANE", "MEM_OFFSET", 
			"MEM_ALIGN", "INT_CONST", "FLOAT_CONST", "NUM_INSTR", "VEC_CONST", "VEC_SHUFFLE", 
			"VEC_LANE_INSTR", "VEC_INSTR", "BLOCK", "BR", "BR_IF", "BR_TABLE", "CALL", 
			"CALL_INDIRECT", "DATA", "DATA_DROP", "DECLARE", "DROP", "ELEM", "ELEM_DROP", 
			"ELSE", "END", "EXPORT", "EXTERN", "FUNC", "GLOBAL", "GLOBAL_GET", "GLOBAL_SET", 
			"IF", "IMPORT", "ITEM", "LOCAL", "LOCAL_GET", "LOCAL_SET", "LOCAL_TEE", 
			"LOOP", "MEMORY", "MEMORY_COPY", "MEMORY_FILL", "MEMORY_GROW", "MEMORY_INIT", 
			"MEMORY_SIZE", "MODULE", "MUT", "NOP", "OFFSET", "PARAM", "REF_FUNC", 
			"REF_IS_NULL", "REF_NULL", "RESULT", "RETURN", "SELECT", "START", "TABLE", 
			"TABLE_COPY", "TABLE_FILL", "TABLE_GET", "TABLE_GROW", "TABLE_INIT", 
			"TABLE_SET", "TABLE_SIZE", "THEN", "TYPE", "UNREACHABLE", "ASSERT_EXHAUSTION", 
			"ASSERT_INVALID", "ASSERT_MALFORMED", "ASSERT_RETURN", "ASSERT_TRAP", 
			"ASSERT_UNLINKABLE", "BINARY", "GET", "INPUT", "INVOKE", "NAN_ARITHMETIC", 
			"NAN_CANONICAL", "OUTPUT", "QUOTE", "REF_EXTERN", "REGISTER", "SCRIPT", 
			"SPACE", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "WatParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WatParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WatParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WatParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(WatParser.INTEGER, 0); }
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_index);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public TypeIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitTypeIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIndexContext typeIndex() throws RecognitionException {
		TypeIndexContext _localctx = new TypeIndexContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public FunctionIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitFunctionIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionIndexContext functionIndex() throws RecognitionException {
		FunctionIndexContext _localctx = new FunctionIndexContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public TableIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitTableIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableIndexContext tableIndex() throws RecognitionException {
		TableIndexContext _localctx = new TableIndexContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tableIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemoryIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public MemoryIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memoryIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitMemoryIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemoryIndexContext memoryIndex() throws RecognitionException {
		MemoryIndexContext _localctx = new MemoryIndexContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_memoryIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public GlobalIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitGlobalIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalIndexContext globalIndex() throws RecognitionException {
		GlobalIndexContext _localctx = new GlobalIndexContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_globalIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public ElementIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitElementIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementIndexContext elementIndex() throws RecognitionException {
		ElementIndexContext _localctx = new ElementIndexContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elementIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public DataIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitDataIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataIndexContext dataIndex() throws RecognitionException {
		DataIndexContext _localctx = new DataIndexContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dataIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public LocalIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitLocalIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalIndexContext localIndex() throws RecognitionException {
		LocalIndexContext _localctx = new LocalIndexContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_localIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelIndexContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public LabelIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitLabelIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelIndexContext labelIndex() throws RecognitionException {
		LabelIndexContext _localctx = new LabelIndexContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_labelIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			index();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(WatParser.STRING, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataStringContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(WatParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(WatParser.STRING, i);
		}
		public DataStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataString; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitDataString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataStringContext dataString() throws RecognitionException {
		DataStringContext _localctx = new DataStringContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dataString);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING) {
				{
				{
				setState(178);
				match(STRING);
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(WatParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(WatParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RefTypeContext extends ParserRuleContext {
		public TerminalNode REF_TYPE() { return getToken(WatParser.REF_TYPE, 0); }
		public RefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitRefType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefTypeContext refType() throws RecognitionException {
		RefTypeContext _localctx = new RefTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_refType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(REF_TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeapTypeContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(WatParser.FUNC, 0); }
		public TerminalNode EXTERN() { return getToken(WatParser.EXTERN, 0); }
		public HeapTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heapType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitHeapType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeapTypeContext heapType() throws RecognitionException {
		HeapTypeContext _localctx = new HeapTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_heapType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_la = _input.LA(1);
			if ( !(_la==EXTERN || _la==FUNC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueTypeContext extends ParserRuleContext {
		public TerminalNode NUM_TYPE() { return getToken(WatParser.NUM_TYPE, 0); }
		public TerminalNode VEC_TYPE() { return getToken(WatParser.VEC_TYPE, 0); }
		public TerminalNode REF_TYPE() { return getToken(WatParser.REF_TYPE, 0); }
		public ValueTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitValueType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueTypeContext valueType() throws RecognitionException {
		ValueTypeContext _localctx = new ValueTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_valueType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM_TYPE) | (1L << VEC_TYPE) | (1L << REF_TYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VecTypeContext extends ParserRuleContext {
		public TerminalNode VEC_TYPE() { return getToken(WatParser.VEC_TYPE, 0); }
		public VecTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vecType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitVecType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VecTypeContext vecType() throws RecognitionException {
		VecTypeContext _localctx = new VecTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_vecType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(VEC_TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VecShapeContext extends ParserRuleContext {
		public TerminalNode VEC_SHAPE() { return getToken(WatParser.VEC_SHAPE, 0); }
		public VecShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vecShape; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitVecShape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VecShapeContext vecShape() throws RecognitionException {
		VecShapeContext _localctx = new VecShapeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_vecShape);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(VEC_SHAPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncTypeContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode FUNC() { return getToken(WatParser.FUNC, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<ResultContext> result() {
			return getRuleContexts(ResultContext.class);
		}
		public ResultContext result(int i) {
			return getRuleContext(ResultContext.class,i);
		}
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(LEFT_PAREN);
			setState(197);
			match(FUNC);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(198);
					param();
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_PAREN) {
				{
				{
				setState(204);
				result();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode RESULT() { return getToken(WatParser.RESULT, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public List<ValueTypeContext> valueType() {
			return getRuleContexts(ValueTypeContext.class);
		}
		public ValueTypeContext valueType(int i) {
			return getRuleContext(ValueTypeContext.class,i);
		}
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_result);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(LEFT_PAREN);
			setState(213);
			match(RESULT);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM_TYPE) | (1L << VEC_TYPE) | (1L << REF_TYPE))) != 0)) {
				{
				{
				setState(214);
				valueType();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode PARAM() { return getToken(WatParser.PARAM, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<ValueTypeContext> valueType() {
			return getRuleContexts(ValueTypeContext.class);
		}
		public ValueTypeContext valueType(int i) {
			return getRuleContext(ValueTypeContext.class,i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(LEFT_PAREN);
			setState(223);
			match(PARAM);
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RIGHT_PAREN:
			case NUM_TYPE:
			case VEC_TYPE:
			case REF_TYPE:
				{
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM_TYPE) | (1L << VEC_TYPE) | (1L << REF_TYPE))) != 0)) {
					{
					{
					setState(224);
					valueType();
					}
					}
					setState(229);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID:
				{
				setState(230);
				id();
				setState(231);
				valueType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(235);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode LOCAL() { return getToken(WatParser.LOCAL, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<ValueTypeContext> valueType() {
			return getRuleContexts(ValueTypeContext.class);
		}
		public ValueTypeContext valueType(int i) {
			return getRuleContext(ValueTypeContext.class,i);
		}
		public LocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitLocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalContext local() throws RecognitionException {
		LocalContext _localctx = new LocalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_local);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(LEFT_PAREN);
			setState(238);
			match(LOCAL);
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RIGHT_PAREN:
			case NUM_TYPE:
			case VEC_TYPE:
			case REF_TYPE:
				{
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM_TYPE) | (1L << VEC_TYPE) | (1L << REF_TYPE))) != 0)) {
					{
					{
					setState(239);
					valueType();
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID:
				{
				setState(245);
				id();
				setState(246);
				valueType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(250);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemTypeContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(WatParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(WatParser.INTEGER, i);
		}
		public MemTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitMemType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemTypeContext memType() throws RecognitionException {
		MemTypeContext _localctx = new MemTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_memType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(INTEGER);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTEGER) {
				{
				setState(253);
				match(INTEGER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableTypeContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(WatParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(WatParser.INTEGER, i);
		}
		public RefTypeContext refType() {
			return getRuleContext(RefTypeContext.class,0);
		}
		public TableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitTableType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableTypeContext tableType() throws RecognitionException {
		TableTypeContext _localctx = new TableTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_tableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(INTEGER);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTEGER) {
				{
				setState(257);
				match(INTEGER);
				}
			}

			setState(260);
			refType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalTypeContext extends ParserRuleContext {
		public ValueTypeContext valueType() {
			return getRuleContext(ValueTypeContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode MUT() { return getToken(WatParser.MUT, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public GlobalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitGlobalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalTypeContext globalType() throws RecognitionException {
		GlobalTypeContext _localctx = new GlobalTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_globalType);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_TYPE:
			case VEC_TYPE:
			case REF_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				valueType();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(LEFT_PAREN);
				setState(264);
				match(MUT);
				setState(265);
				valueType();
				setState(266);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WatParser.ID, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(270);
				match(ID);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockTypeContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TypeUseContext typeUse() {
			return getRuleContext(TypeUseContext.class,0);
		}
		public BlockTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitBlockType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockTypeContext blockType() throws RecognitionException {
		BlockTypeContext _localctx = new BlockTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_blockType);
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(273);
					result();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				typeUse();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemArgContext extends ParserRuleContext {
		public TerminalNode MEM_OFFSET() { return getToken(WatParser.MEM_OFFSET, 0); }
		public TerminalNode MEM_ALIGN() { return getToken(WatParser.MEM_ALIGN, 0); }
		public MemArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memArg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitMemArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemArgContext memArg() throws RecognitionException {
		MemArgContext _localctx = new MemArgContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_memArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MEM_OFFSET) {
				{
				setState(279);
				match(MEM_OFFSET);
				}
			}

			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MEM_ALIGN) {
				{
				setState(282);
				match(MEM_ALIGN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockInstrContext extends ParserRuleContext {
		public TerminalNode BLOCK() { return getToken(WatParser.BLOCK, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public BlockTypeContext blockType() {
			return getRuleContext(BlockTypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode END() { return getToken(WatParser.END, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode LOOP() { return getToken(WatParser.LOOP, 0); }
		public TerminalNode IF() { return getToken(WatParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(WatParser.ELSE, 0); }
		public BlockInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitBlockInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockInstrContext blockInstr() throws RecognitionException {
		BlockInstrContext _localctx = new BlockInstrContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_blockInstr);
		int _la;
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				match(BLOCK);
				setState(286);
				label();
				setState(287);
				blockType();
				setState(288);
				expr();
				setState(289);
				match(END);
				setState(291);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(290);
					id();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(LOOP);
				setState(294);
				label();
				setState(295);
				blockType();
				setState(296);
				expr();
				setState(297);
				match(END);
				setState(299);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(298);
					id();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(301);
				match(IF);
				setState(302);
				label();
				setState(303);
				blockType();
				setState(304);
				expr();
				setState(305);
				match(END);
				setState(307);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(306);
					id();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(309);
				match(IF);
				setState(310);
				label();
				setState(311);
				blockType();
				setState(312);
				expr();
				setState(313);
				match(ELSE);
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(314);
					id();
					}
				}

				setState(317);
				expr();
				setState(318);
				match(END);
				setState(320);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(319);
					id();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlainInstrContext extends ParserRuleContext {
		public ControlInstrContext controlInstr() {
			return getRuleContext(ControlInstrContext.class,0);
		}
		public ReferenceInstrContext referenceInstr() {
			return getRuleContext(ReferenceInstrContext.class,0);
		}
		public ParametricInstrContext parametricInstr() {
			return getRuleContext(ParametricInstrContext.class,0);
		}
		public VariableInstrContext variableInstr() {
			return getRuleContext(VariableInstrContext.class,0);
		}
		public TableInstrContext tableInstr() {
			return getRuleContext(TableInstrContext.class,0);
		}
		public MemoryInstrContext memoryInstr() {
			return getRuleContext(MemoryInstrContext.class,0);
		}
		public NumericInstrContext numericInstr() {
			return getRuleContext(NumericInstrContext.class,0);
		}
		public VectorInstrContext vectorInstr() {
			return getRuleContext(VectorInstrContext.class,0);
		}
		public PlainInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitPlainInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlainInstrContext plainInstr() throws RecognitionException {
		PlainInstrContext _localctx = new PlainInstrContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_plainInstr);
		try {
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BR:
			case BR_IF:
			case BR_TABLE:
			case CALL:
			case CALL_INDIRECT:
			case NOP:
			case RETURN:
			case UNREACHABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				controlInstr();
				}
				break;
			case REF_FUNC:
			case REF_IS_NULL:
			case REF_NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				referenceInstr();
				}
				break;
			case DROP:
			case SELECT:
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				parametricInstr();
				}
				break;
			case GLOBAL_GET:
			case GLOBAL_SET:
			case LOCAL_GET:
			case LOCAL_SET:
			case LOCAL_TEE:
				enterOuterAlt(_localctx, 4);
				{
				setState(327);
				variableInstr();
				}
				break;
			case ELEM_DROP:
			case TABLE_COPY:
			case TABLE_FILL:
			case TABLE_GET:
			case TABLE_GROW:
			case TABLE_INIT:
			case TABLE_SET:
			case TABLE_SIZE:
				enterOuterAlt(_localctx, 5);
				{
				setState(328);
				tableInstr();
				}
				break;
			case NUM_LOAD:
			case NUM_STORE:
			case VEC_LOAD:
			case VEC_LOAD_LANE:
			case VEC_STORE:
			case VEC_STORE_LANE:
			case DATA_DROP:
			case MEMORY_COPY:
			case MEMORY_FILL:
			case MEMORY_GROW:
			case MEMORY_INIT:
			case MEMORY_SIZE:
				enterOuterAlt(_localctx, 6);
				{
				setState(329);
				memoryInstr();
				}
				break;
			case INT_CONST:
			case FLOAT_CONST:
			case NUM_INSTR:
				enterOuterAlt(_localctx, 7);
				{
				setState(330);
				numericInstr();
				}
				break;
			case VEC_CONST:
			case VEC_SHUFFLE:
			case VEC_LANE_INSTR:
			case VEC_INSTR:
				enterOuterAlt(_localctx, 8);
				{
				setState(331);
				vectorInstr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlInstrContext extends ParserRuleContext {
		public TerminalNode UNREACHABLE() { return getToken(WatParser.UNREACHABLE, 0); }
		public TerminalNode NOP() { return getToken(WatParser.NOP, 0); }
		public TerminalNode BR() { return getToken(WatParser.BR, 0); }
		public List<LabelIndexContext> labelIndex() {
			return getRuleContexts(LabelIndexContext.class);
		}
		public LabelIndexContext labelIndex(int i) {
			return getRuleContext(LabelIndexContext.class,i);
		}
		public TerminalNode BR_IF() { return getToken(WatParser.BR_IF, 0); }
		public TerminalNode BR_TABLE() { return getToken(WatParser.BR_TABLE, 0); }
		public TerminalNode RETURN() { return getToken(WatParser.RETURN, 0); }
		public TerminalNode CALL() { return getToken(WatParser.CALL, 0); }
		public FunctionIndexContext functionIndex() {
			return getRuleContext(FunctionIndexContext.class,0);
		}
		public TerminalNode CALL_INDIRECT() { return getToken(WatParser.CALL_INDIRECT, 0); }
		public TypeUseContext typeUse() {
			return getRuleContext(TypeUseContext.class,0);
		}
		public TableIndexContext tableIndex() {
			return getRuleContext(TableIndexContext.class,0);
		}
		public ControlInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitControlInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlInstrContext controlInstr() throws RecognitionException {
		ControlInstrContext _localctx = new ControlInstrContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_controlInstr);
		try {
			int _alt;
			setState(354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNREACHABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				match(UNREACHABLE);
				}
				break;
			case NOP:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				match(NOP);
				}
				break;
			case BR:
				enterOuterAlt(_localctx, 3);
				{
				setState(336);
				match(BR);
				setState(337);
				labelIndex();
				}
				break;
			case BR_IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(338);
				match(BR_IF);
				setState(339);
				labelIndex();
				}
				break;
			case BR_TABLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(340);
				match(BR_TABLE);
				setState(342); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(341);
						labelIndex();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(344); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(346);
				match(RETURN);
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 7);
				{
				setState(347);
				match(CALL);
				setState(348);
				functionIndex();
				}
				break;
			case CALL_INDIRECT:
				enterOuterAlt(_localctx, 8);
				{
				setState(349);
				match(CALL_INDIRECT);
				setState(351);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(350);
					tableIndex();
					}
					break;
				}
				setState(353);
				typeUse();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceInstrContext extends ParserRuleContext {
		public TerminalNode REF_NULL() { return getToken(WatParser.REF_NULL, 0); }
		public HeapTypeContext heapType() {
			return getRuleContext(HeapTypeContext.class,0);
		}
		public TerminalNode REF_IS_NULL() { return getToken(WatParser.REF_IS_NULL, 0); }
		public TerminalNode REF_FUNC() { return getToken(WatParser.REF_FUNC, 0); }
		public FunctionIndexContext functionIndex() {
			return getRuleContext(FunctionIndexContext.class,0);
		}
		public ReferenceInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitReferenceInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceInstrContext referenceInstr() throws RecognitionException {
		ReferenceInstrContext _localctx = new ReferenceInstrContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_referenceInstr);
		try {
			setState(361);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REF_NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				match(REF_NULL);
				setState(357);
				heapType();
				}
				break;
			case REF_IS_NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
				match(REF_IS_NULL);
				}
				break;
			case REF_FUNC:
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
				match(REF_FUNC);
				setState(360);
				functionIndex();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametricInstrContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(WatParser.DROP, 0); }
		public TerminalNode SELECT() { return getToken(WatParser.SELECT, 0); }
		public List<ResultContext> result() {
			return getRuleContexts(ResultContext.class);
		}
		public ResultContext result(int i) {
			return getRuleContext(ResultContext.class,i);
		}
		public ParametricInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametricInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitParametricInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametricInstrContext parametricInstr() throws RecognitionException {
		ParametricInstrContext _localctx = new ParametricInstrContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_parametricInstr);
		try {
			int _alt;
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DROP:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				match(DROP);
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(SELECT);
				setState(368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(365);
						result();
						}
						} 
					}
					setState(370);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInstrContext extends ParserRuleContext {
		public TerminalNode LOCAL_GET() { return getToken(WatParser.LOCAL_GET, 0); }
		public LocalIndexContext localIndex() {
			return getRuleContext(LocalIndexContext.class,0);
		}
		public TerminalNode LOCAL_SET() { return getToken(WatParser.LOCAL_SET, 0); }
		public TerminalNode LOCAL_TEE() { return getToken(WatParser.LOCAL_TEE, 0); }
		public TerminalNode GLOBAL_GET() { return getToken(WatParser.GLOBAL_GET, 0); }
		public GlobalIndexContext globalIndex() {
			return getRuleContext(GlobalIndexContext.class,0);
		}
		public TerminalNode GLOBAL_SET() { return getToken(WatParser.GLOBAL_SET, 0); }
		public VariableInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitVariableInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInstrContext variableInstr() throws RecognitionException {
		VariableInstrContext _localctx = new VariableInstrContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_variableInstr);
		try {
			setState(383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOCAL_GET:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				match(LOCAL_GET);
				setState(374);
				localIndex();
				}
				break;
			case LOCAL_SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(375);
				match(LOCAL_SET);
				setState(376);
				localIndex();
				}
				break;
			case LOCAL_TEE:
				enterOuterAlt(_localctx, 3);
				{
				setState(377);
				match(LOCAL_TEE);
				setState(378);
				localIndex();
				}
				break;
			case GLOBAL_GET:
				enterOuterAlt(_localctx, 4);
				{
				setState(379);
				match(GLOBAL_GET);
				setState(380);
				globalIndex();
				}
				break;
			case GLOBAL_SET:
				enterOuterAlt(_localctx, 5);
				{
				setState(381);
				match(GLOBAL_SET);
				setState(382);
				globalIndex();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableInstrContext extends ParserRuleContext {
		public TerminalNode TABLE_GET() { return getToken(WatParser.TABLE_GET, 0); }
		public List<TableIndexContext> tableIndex() {
			return getRuleContexts(TableIndexContext.class);
		}
		public TableIndexContext tableIndex(int i) {
			return getRuleContext(TableIndexContext.class,i);
		}
		public TerminalNode TABLE_SET() { return getToken(WatParser.TABLE_SET, 0); }
		public TerminalNode TABLE_SIZE() { return getToken(WatParser.TABLE_SIZE, 0); }
		public TerminalNode TABLE_GROW() { return getToken(WatParser.TABLE_GROW, 0); }
		public TerminalNode TABLE_FILL() { return getToken(WatParser.TABLE_FILL, 0); }
		public TerminalNode TABLE_COPY() { return getToken(WatParser.TABLE_COPY, 0); }
		public TerminalNode TABLE_INIT() { return getToken(WatParser.TABLE_INIT, 0); }
		public ElementIndexContext elementIndex() {
			return getRuleContext(ElementIndexContext.class,0);
		}
		public TerminalNode ELEM_DROP() { return getToken(WatParser.ELEM_DROP, 0); }
		public TableInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitTableInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableInstrContext tableInstr() throws RecognitionException {
		TableInstrContext _localctx = new TableInstrContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_tableInstr);
		try {
			setState(418);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TABLE_GET:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				match(TABLE_GET);
				setState(387);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(386);
					tableIndex();
					}
					break;
				}
				}
				break;
			case TABLE_SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				match(TABLE_SET);
				setState(391);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(390);
					tableIndex();
					}
					break;
				}
				}
				break;
			case TABLE_SIZE:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				match(TABLE_SIZE);
				setState(395);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(394);
					tableIndex();
					}
					break;
				}
				}
				break;
			case TABLE_GROW:
				enterOuterAlt(_localctx, 4);
				{
				setState(397);
				match(TABLE_GROW);
				setState(399);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(398);
					tableIndex();
					}
					break;
				}
				}
				break;
			case TABLE_FILL:
				enterOuterAlt(_localctx, 5);
				{
				setState(401);
				match(TABLE_FILL);
				setState(403);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(402);
					tableIndex();
					}
					break;
				}
				}
				break;
			case TABLE_COPY:
				enterOuterAlt(_localctx, 6);
				{
				setState(405);
				match(TABLE_COPY);
				setState(409);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(406);
					tableIndex();
					setState(407);
					tableIndex();
					}
					break;
				}
				}
				break;
			case TABLE_INIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(411);
				match(TABLE_INIT);
				setState(413);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(412);
					tableIndex();
					}
					break;
				}
				setState(415);
				elementIndex();
				}
				break;
			case ELEM_DROP:
				enterOuterAlt(_localctx, 8);
				{
				setState(416);
				match(ELEM_DROP);
				setState(417);
				elementIndex();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemoryInstrContext extends ParserRuleContext {
		public TerminalNode NUM_LOAD() { return getToken(WatParser.NUM_LOAD, 0); }
		public MemArgContext memArg() {
			return getRuleContext(MemArgContext.class,0);
		}
		public TerminalNode NUM_STORE() { return getToken(WatParser.NUM_STORE, 0); }
		public TerminalNode VEC_LOAD() { return getToken(WatParser.VEC_LOAD, 0); }
		public TerminalNode VEC_STORE() { return getToken(WatParser.VEC_STORE, 0); }
		public TerminalNode VEC_LOAD_LANE() { return getToken(WatParser.VEC_LOAD_LANE, 0); }
		public TerminalNode INTEGER() { return getToken(WatParser.INTEGER, 0); }
		public TerminalNode VEC_STORE_LANE() { return getToken(WatParser.VEC_STORE_LANE, 0); }
		public TerminalNode MEMORY_SIZE() { return getToken(WatParser.MEMORY_SIZE, 0); }
		public TerminalNode MEMORY_GROW() { return getToken(WatParser.MEMORY_GROW, 0); }
		public TerminalNode MEMORY_FILL() { return getToken(WatParser.MEMORY_FILL, 0); }
		public TerminalNode MEMORY_COPY() { return getToken(WatParser.MEMORY_COPY, 0); }
		public TerminalNode MEMORY_INIT() { return getToken(WatParser.MEMORY_INIT, 0); }
		public DataIndexContext dataIndex() {
			return getRuleContext(DataIndexContext.class,0);
		}
		public TerminalNode DATA_DROP() { return getToken(WatParser.DATA_DROP, 0); }
		public MemoryInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memoryInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitMemoryInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemoryInstrContext memoryInstr() throws RecognitionException {
		MemoryInstrContext _localctx = new MemoryInstrContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_memoryInstr);
		try {
			setState(444);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_LOAD:
				enterOuterAlt(_localctx, 1);
				{
				setState(420);
				match(NUM_LOAD);
				setState(421);
				memArg();
				}
				break;
			case NUM_STORE:
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				match(NUM_STORE);
				setState(423);
				memArg();
				}
				break;
			case VEC_LOAD:
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				match(VEC_LOAD);
				setState(425);
				memArg();
				}
				break;
			case VEC_STORE:
				enterOuterAlt(_localctx, 4);
				{
				setState(426);
				match(VEC_STORE);
				setState(427);
				memArg();
				}
				break;
			case VEC_LOAD_LANE:
				enterOuterAlt(_localctx, 5);
				{
				setState(428);
				match(VEC_LOAD_LANE);
				setState(429);
				memArg();
				setState(430);
				match(INTEGER);
				}
				break;
			case VEC_STORE_LANE:
				enterOuterAlt(_localctx, 6);
				{
				setState(432);
				match(VEC_STORE_LANE);
				setState(433);
				memArg();
				setState(434);
				match(INTEGER);
				}
				break;
			case MEMORY_SIZE:
				enterOuterAlt(_localctx, 7);
				{
				setState(436);
				match(MEMORY_SIZE);
				}
				break;
			case MEMORY_GROW:
				enterOuterAlt(_localctx, 8);
				{
				setState(437);
				match(MEMORY_GROW);
				}
				break;
			case MEMORY_FILL:
				enterOuterAlt(_localctx, 9);
				{
				setState(438);
				match(MEMORY_FILL);
				}
				break;
			case MEMORY_COPY:
				enterOuterAlt(_localctx, 10);
				{
				setState(439);
				match(MEMORY_COPY);
				}
				break;
			case MEMORY_INIT:
				enterOuterAlt(_localctx, 11);
				{
				setState(440);
				match(MEMORY_INIT);
				setState(441);
				dataIndex();
				}
				break;
			case DATA_DROP:
				enterOuterAlt(_localctx, 12);
				{
				setState(442);
				match(DATA_DROP);
				setState(443);
				dataIndex();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericInstrContext extends ParserRuleContext {
		public TerminalNode INT_CONST() { return getToken(WatParser.INT_CONST, 0); }
		public TerminalNode INTEGER() { return getToken(WatParser.INTEGER, 0); }
		public TerminalNode FLOAT_CONST() { return getToken(WatParser.FLOAT_CONST, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode NUM_INSTR() { return getToken(WatParser.NUM_INSTR, 0); }
		public NumericInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitNumericInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericInstrContext numericInstr() throws RecognitionException {
		NumericInstrContext _localctx = new NumericInstrContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_numericInstr);
		try {
			setState(451);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				match(INT_CONST);
				setState(447);
				match(INTEGER);
				}
				break;
			case FLOAT_CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(448);
				match(FLOAT_CONST);
				setState(449);
				number();
				}
				break;
			case NUM_INSTR:
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				match(NUM_INSTR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VectorInstrContext extends ParserRuleContext {
		public TerminalNode VEC_CONST() { return getToken(WatParser.VEC_CONST, 0); }
		public VecShapeContext vecShape() {
			return getRuleContext(VecShapeContext.class,0);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode VEC_SHUFFLE() { return getToken(WatParser.VEC_SHUFFLE, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(WatParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(WatParser.INTEGER, i);
		}
		public TerminalNode VEC_LANE_INSTR() { return getToken(WatParser.VEC_LANE_INSTR, 0); }
		public TerminalNode VEC_INSTR() { return getToken(WatParser.VEC_INSTR, 0); }
		public VectorInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vectorInstr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitVectorInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorInstrContext vectorInstr() throws RecognitionException {
		VectorInstrContext _localctx = new VectorInstrContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_vectorInstr);
		try {
			int _alt;
			setState(469);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VEC_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				match(VEC_CONST);
				setState(454);
				vecShape();
				setState(456); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(455);
						number();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(458); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case VEC_SHUFFLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				match(VEC_SHUFFLE);
				setState(462); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(461);
						match(INTEGER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(464); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case VEC_LANE_INSTR:
				enterOuterAlt(_localctx, 3);
				{
				setState(466);
				match(VEC_LANE_INSTR);
				setState(467);
				match(INTEGER);
				}
				break;
			case VEC_INSTR:
				enterOuterAlt(_localctx, 4);
				{
				setState(468);
				match(VEC_INSTR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstrContext extends ParserRuleContext {
		public PlainInstrContext plainInstr() {
			return getRuleContext(PlainInstrContext.class,0);
		}
		public BlockInstrContext blockInstr() {
			return getRuleContext(BlockInstrContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(WatParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(WatParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(WatParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(WatParser.RIGHT_PAREN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BLOCK() { return getToken(WatParser.BLOCK, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public BlockTypeContext blockType() {
			return getRuleContext(BlockTypeContext.class,0);
		}
		public TerminalNode LOOP() { return getToken(WatParser.LOOP, 0); }
		public TerminalNode IF() { return getToken(WatParser.IF, 0); }
		public TerminalNode THEN() { return getToken(WatParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(WatParser.ELSE, 0); }
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_instr);
		int _la;
		try {
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(471);
				plainInstr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(472);
				blockInstr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(473);
				match(LEFT_PAREN);
				setState(474);
				blockInstr();
				setState(475);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(477);
				match(LEFT_PAREN);
				setState(478);
				plainInstr();
				setState(479);
				expr();
				setState(480);
				match(RIGHT_PAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(482);
				match(LEFT_PAREN);
				setState(483);
				match(BLOCK);
				setState(484);
				label();
				setState(485);
				blockType();
				setState(486);
				expr();
				setState(487);
				match(RIGHT_PAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(489);
				match(LEFT_PAREN);
				setState(490);
				match(LOOP);
				setState(491);
				label();
				setState(492);
				blockType();
				setState(493);
				expr();
				setState(494);
				match(RIGHT_PAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(496);
				match(LEFT_PAREN);
				setState(497);
				match(IF);
				setState(498);
				label();
				setState(499);
				blockType();
				setState(500);
				expr();
				setState(501);
				match(LEFT_PAREN);
				setState(502);
				match(THEN);
				setState(503);
				expr();
				setState(504);
				match(RIGHT_PAREN);
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(505);
					match(LEFT_PAREN);
					setState(506);
					match(ELSE);
					setState(507);
					expr();
					setState(508);
					match(RIGHT_PAREN);
					}
				}

				setState(512);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(516);
					instr();
					}
					} 
				}
				setState(521);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode MODULE() { return getToken(WatParser.MODULE, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public TerminalNode EOF() { return getToken(WatParser.EOF, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<ModuleFieldContext> moduleField() {
			return getRuleContexts(ModuleFieldContext.class);
		}
		public ModuleFieldContext moduleField(int i) {
			return getRuleContext(ModuleFieldContext.class,i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_module);
		int _la;
		try {
			setState(542);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				match(LEFT_PAREN);
				setState(523);
				match(MODULE);
				setState(525);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(524);
					id();
					}
				}

				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LEFT_PAREN) {
					{
					{
					setState(527);
					moduleField();
					}
					}
					setState(532);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(533);
				match(RIGHT_PAREN);
				setState(534);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LEFT_PAREN) {
					{
					{
					setState(535);
					moduleField();
					}
					}
					setState(540);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(541);
				match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleFieldContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ModuleImportContext moduleImport() {
			return getRuleContext(ModuleImportContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public MemContext mem() {
			return getRuleContext(MemContext.class,0);
		}
		public GlobalContext global() {
			return getRuleContext(GlobalContext.class,0);
		}
		public ModuleExportContext moduleExport() {
			return getRuleContext(ModuleExportContext.class,0);
		}
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public ElemContext elem() {
			return getRuleContext(ElemContext.class,0);
		}
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public ModuleFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleField; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitModuleField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleFieldContext moduleField() throws RecognitionException {
		ModuleFieldContext _localctx = new ModuleFieldContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_moduleField);
		try {
			setState(554);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(544);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
				moduleImport();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(546);
				func();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(547);
				table();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(548);
				mem();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(549);
				global();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(550);
				moduleExport();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(551);
				start();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(552);
				elem();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(553);
				data();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode TYPE() { return getToken(WatParser.TYPE, 0); }
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			match(LEFT_PAREN);
			setState(557);
			match(TYPE);
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(558);
				id();
				}
			}

			setState(561);
			funcType();
			setState(562);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode FUNC() { return getToken(WatParser.FUNC, 0); }
		public FuncDescContext funcDesc() {
			return getRuleContext(FuncDescContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			match(LEFT_PAREN);
			setState(565);
			match(FUNC);
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(566);
				id();
				}
			}

			setState(569);
			funcDesc();
			setState(570);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode TABLE() { return getToken(WatParser.TABLE, 0); }
		public TableDescContext tableDesc() {
			return getRuleContext(TableDescContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			match(LEFT_PAREN);
			setState(573);
			match(TABLE);
			setState(575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(574);
				id();
				}
			}

			setState(577);
			tableDesc();
			setState(578);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode MEMORY() { return getToken(WatParser.MEMORY, 0); }
		public MemDescContext memDesc() {
			return getRuleContext(MemDescContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public MemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitMem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemContext mem() throws RecognitionException {
		MemContext _localctx = new MemContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_mem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			match(LEFT_PAREN);
			setState(581);
			match(MEMORY);
			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(582);
				id();
				}
			}

			setState(585);
			memDesc();
			setState(586);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode GLOBAL() { return getToken(WatParser.GLOBAL, 0); }
		public GlobalDescContext globalDesc() {
			return getRuleContext(GlobalDescContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public GlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitGlobal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalContext global() throws RecognitionException {
		GlobalContext _localctx = new GlobalContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			match(LEFT_PAREN);
			setState(589);
			match(GLOBAL);
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(590);
				id();
				}
			}

			setState(593);
			globalDesc();
			setState(594);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleImportContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode IMPORT() { return getToken(WatParser.IMPORT, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public ImportDescContext importDesc() {
			return getRuleContext(ImportDescContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public ModuleImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleImport; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitModuleImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleImportContext moduleImport() throws RecognitionException {
		ModuleImportContext _localctx = new ModuleImportContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_moduleImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(LEFT_PAREN);
			setState(597);
			match(IMPORT);
			setState(598);
			name();
			setState(599);
			name();
			setState(600);
			importDesc();
			setState(601);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleExportContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode EXPORT() { return getToken(WatParser.EXPORT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExportDescContext exportDesc() {
			return getRuleContext(ExportDescContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public ModuleExportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleExport; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitModuleExport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleExportContext moduleExport() throws RecognitionException {
		ModuleExportContext _localctx = new ModuleExportContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_moduleExport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(LEFT_PAREN);
			setState(604);
			match(EXPORT);
			setState(605);
			name();
			setState(606);
			exportDesc();
			setState(607);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode START() { return getToken(WatParser.START, 0); }
		public FunctionIndexContext functionIndex() {
			return getRuleContext(FunctionIndexContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			match(LEFT_PAREN);
			setState(610);
			match(START);
			setState(611);
			functionIndex();
			setState(612);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElemContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode ELEM() { return getToken(WatParser.ELEM, 0); }
		public ElemListContext elemList() {
			return getRuleContext(ElemListContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public TableUseContext tableUse() {
			return getRuleContext(TableUseContext.class,0);
		}
		public List<FunctionIndexContext> functionIndex() {
			return getRuleContexts(FunctionIndexContext.class);
		}
		public FunctionIndexContext functionIndex(int i) {
			return getRuleContext(FunctionIndexContext.class,i);
		}
		public TerminalNode DECLARE() { return getToken(WatParser.DECLARE, 0); }
		public ElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElemContext elem() throws RecognitionException {
		ElemContext _localctx = new ElemContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_elem);
		int _la;
		try {
			setState(657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(614);
				match(LEFT_PAREN);
				setState(615);
				match(ELEM);
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(616);
					id();
					}
				}

				setState(619);
				elemList();
				setState(620);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(622);
				match(LEFT_PAREN);
				setState(623);
				match(ELEM);
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(624);
					id();
					}
				}

				setState(628);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(627);
					tableUse();
					}
					break;
				}
				setState(630);
				offset();
				setState(631);
				elemList();
				setState(632);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(634);
				match(LEFT_PAREN);
				setState(635);
				match(ELEM);
				setState(637);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(636);
					id();
					}
				}

				setState(639);
				offset();
				setState(643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INTEGER || _la==ID) {
					{
					{
					setState(640);
					functionIndex();
					}
					}
					setState(645);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(646);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(648);
				match(LEFT_PAREN);
				setState(649);
				match(ELEM);
				setState(651);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(650);
					id();
					}
				}

				setState(653);
				match(DECLARE);
				setState(654);
				elemList();
				setState(655);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode DATA() { return getToken(WatParser.DATA, 0); }
		public DataStringContext dataString() {
			return getRuleContext(DataStringContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public MemUseContext memUse() {
			return getRuleContext(MemUseContext.class,0);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_data);
		int _la;
		try {
			setState(679);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(659);
				match(LEFT_PAREN);
				setState(660);
				match(DATA);
				setState(662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(661);
					id();
					}
				}

				setState(664);
				dataString();
				setState(665);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(667);
				match(LEFT_PAREN);
				setState(668);
				match(DATA);
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(669);
					id();
					}
				}

				setState(673);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(672);
					memUse();
					}
					break;
				}
				setState(675);
				offset();
				setState(676);
				dataString();
				setState(677);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OffsetContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode OFFSET() { return getToken(WatParser.OFFSET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public InstrContext instr() {
			return getRuleContext(InstrContext.class,0);
		}
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitOffset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_offset);
		try {
			setState(687);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(681);
				match(LEFT_PAREN);
				setState(682);
				match(OFFSET);
				setState(683);
				expr();
				setState(684);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(686);
				instr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode ITEM() { return getToken(WatParser.ITEM, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public InstrContext instr() {
			return getRuleContext(InstrContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_item);
		try {
			setState(695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(689);
				match(LEFT_PAREN);
				setState(690);
				match(ITEM);
				setState(691);
				expr();
				setState(692);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(694);
				instr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineImportContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode IMPORT() { return getToken(WatParser.IMPORT, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public InlineImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineImport; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitInlineImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineImportContext inlineImport() throws RecognitionException {
		InlineImportContext _localctx = new InlineImportContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_inlineImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(LEFT_PAREN);
			setState(698);
			match(IMPORT);
			setState(699);
			name();
			setState(700);
			name();
			setState(701);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineExportContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode EXPORT() { return getToken(WatParser.EXPORT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public InlineExportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineExport; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitInlineExport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineExportContext inlineExport() throws RecognitionException {
		InlineExportContext _localctx = new InlineExportContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_inlineExport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			match(LEFT_PAREN);
			setState(704);
			match(EXPORT);
			setState(705);
			name();
			setState(706);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemUseContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode MEMORY() { return getToken(WatParser.MEMORY, 0); }
		public MemoryIndexContext memoryIndex() {
			return getRuleContext(MemoryIndexContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public MemUseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memUse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitMemUse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemUseContext memUse() throws RecognitionException {
		MemUseContext _localctx = new MemUseContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_memUse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			match(LEFT_PAREN);
			setState(709);
			match(MEMORY);
			setState(710);
			memoryIndex();
			setState(711);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableUseContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode TABLE() { return getToken(WatParser.TABLE, 0); }
		public TableIndexContext tableIndex() {
			return getRuleContext(TableIndexContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public TableUseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableUse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitTableUse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableUseContext tableUse() throws RecognitionException {
		TableUseContext _localctx = new TableUseContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_tableUse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(713);
			match(LEFT_PAREN);
			setState(714);
			match(TABLE);
			setState(715);
			tableIndex();
			setState(716);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeUseContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode TYPE() { return getToken(WatParser.TYPE, 0); }
		public TypeIndexContext typeIndex() {
			return getRuleContext(TypeIndexContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<ResultContext> result() {
			return getRuleContexts(ResultContext.class);
		}
		public ResultContext result(int i) {
			return getRuleContext(ResultContext.class,i);
		}
		public TypeUseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeUse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitTypeUse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeUseContext typeUse() throws RecognitionException {
		TypeUseContext _localctx = new TypeUseContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_typeUse);
		try {
			int _alt;
			setState(746);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(718);
				match(LEFT_PAREN);
				setState(719);
				match(TYPE);
				setState(720);
				typeIndex();
				setState(721);
				match(RIGHT_PAREN);
				setState(725);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(722);
						param();
						}
						} 
					}
					setState(727);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
				}
				setState(731);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(728);
						result();
						}
						} 
					}
					setState(733);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(737);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(734);
						param();
						}
						} 
					}
					setState(739);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				}
				setState(743);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(740);
						result();
						}
						} 
					}
					setState(745);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDescContext extends ParserRuleContext {
		public TypeUseContext typeUse() {
			return getRuleContext(TypeUseContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<LocalContext> local() {
			return getRuleContexts(LocalContext.class);
		}
		public LocalContext local(int i) {
			return getRuleContext(LocalContext.class,i);
		}
		public InlineImportContext inlineImport() {
			return getRuleContext(InlineImportContext.class,0);
		}
		public InlineExportContext inlineExport() {
			return getRuleContext(InlineExportContext.class,0);
		}
		public FuncDescContext funcDesc() {
			return getRuleContext(FuncDescContext.class,0);
		}
		public FuncDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDesc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitFuncDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDescContext funcDesc() throws RecognitionException {
		FuncDescContext _localctx = new FuncDescContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_funcDesc);
		try {
			int _alt;
			setState(763);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(748);
				typeUse();
				setState(752);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(749);
						local();
						}
						} 
					}
					setState(754);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
				}
				setState(755);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(757);
				inlineImport();
				setState(758);
				typeUse();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(760);
				inlineExport();
				setState(761);
				funcDesc();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableDescContext extends ParserRuleContext {
		public TableTypeContext tableType() {
			return getRuleContext(TableTypeContext.class,0);
		}
		public InlineImportContext inlineImport() {
			return getRuleContext(InlineImportContext.class,0);
		}
		public InlineExportContext inlineExport() {
			return getRuleContext(InlineExportContext.class,0);
		}
		public TableDescContext tableDesc() {
			return getRuleContext(TableDescContext.class,0);
		}
		public RefTypeContext refType() {
			return getRuleContext(RefTypeContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode ELEM() { return getToken(WatParser.ELEM, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<FunctionIndexContext> functionIndex() {
			return getRuleContexts(FunctionIndexContext.class);
		}
		public FunctionIndexContext functionIndex(int i) {
			return getRuleContext(FunctionIndexContext.class,i);
		}
		public TableDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableDesc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitTableDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableDescContext tableDesc() throws RecognitionException {
		TableDescContext _localctx = new TableDescContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_tableDesc);
		int _la;
		try {
			setState(794);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(765);
				tableType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(766);
				inlineImport();
				setState(767);
				tableType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(769);
				inlineExport();
				setState(770);
				tableDesc();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(772);
				refType();
				setState(773);
				match(LEFT_PAREN);
				setState(774);
				match(ELEM);
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << NUM_LOAD) | (1L << NUM_STORE) | (1L << VEC_LOAD) | (1L << VEC_LOAD_LANE) | (1L << VEC_STORE) | (1L << VEC_STORE_LANE) | (1L << INT_CONST) | (1L << FLOAT_CONST) | (1L << NUM_INSTR) | (1L << VEC_CONST) | (1L << VEC_SHUFFLE) | (1L << VEC_LANE_INSTR) | (1L << VEC_INSTR) | (1L << BLOCK) | (1L << BR) | (1L << BR_IF) | (1L << BR_TABLE) | (1L << CALL) | (1L << CALL_INDIRECT) | (1L << DATA_DROP) | (1L << DROP) | (1L << ELEM_DROP) | (1L << GLOBAL_GET) | (1L << GLOBAL_SET) | (1L << IF) | (1L << LOCAL_GET) | (1L << LOCAL_SET) | (1L << LOCAL_TEE) | (1L << LOOP) | (1L << MEMORY_COPY) | (1L << MEMORY_FILL) | (1L << MEMORY_GROW) | (1L << MEMORY_INIT) | (1L << MEMORY_SIZE) | (1L << NOP))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (REF_FUNC - 65)) | (1L << (REF_IS_NULL - 65)) | (1L << (REF_NULL - 65)) | (1L << (RETURN - 65)) | (1L << (SELECT - 65)) | (1L << (TABLE_COPY - 65)) | (1L << (TABLE_FILL - 65)) | (1L << (TABLE_GET - 65)) | (1L << (TABLE_GROW - 65)) | (1L << (TABLE_INIT - 65)) | (1L << (TABLE_SET - 65)) | (1L << (TABLE_SIZE - 65)) | (1L << (UNREACHABLE - 65)))) != 0)) {
					{
					{
					setState(775);
					item();
					}
					}
					setState(780);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(781);
				match(RIGHT_PAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(783);
				refType();
				setState(784);
				match(LEFT_PAREN);
				setState(785);
				match(ELEM);
				setState(789);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INTEGER || _la==ID) {
					{
					{
					setState(786);
					functionIndex();
					}
					}
					setState(791);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(792);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemDescContext extends ParserRuleContext {
		public MemTypeContext memType() {
			return getRuleContext(MemTypeContext.class,0);
		}
		public InlineImportContext inlineImport() {
			return getRuleContext(InlineImportContext.class,0);
		}
		public InlineExportContext inlineExport() {
			return getRuleContext(InlineExportContext.class,0);
		}
		public MemDescContext memDesc() {
			return getRuleContext(MemDescContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode DATA() { return getToken(WatParser.DATA, 0); }
		public DataStringContext dataString() {
			return getRuleContext(DataStringContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public MemDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memDesc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitMemDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemDescContext memDesc() throws RecognitionException {
		MemDescContext _localctx = new MemDescContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_memDesc);
		try {
			setState(808);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(796);
				memType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(797);
				inlineImport();
				setState(798);
				memType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(800);
				inlineExport();
				setState(801);
				memDesc();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(803);
				match(LEFT_PAREN);
				setState(804);
				match(DATA);
				setState(805);
				dataString();
				setState(806);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalDescContext extends ParserRuleContext {
		public GlobalTypeContext globalType() {
			return getRuleContext(GlobalTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InlineImportContext inlineImport() {
			return getRuleContext(InlineImportContext.class,0);
		}
		public InlineExportContext inlineExport() {
			return getRuleContext(InlineExportContext.class,0);
		}
		public GlobalDescContext globalDesc() {
			return getRuleContext(GlobalDescContext.class,0);
		}
		public GlobalDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDesc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitGlobalDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalDescContext globalDesc() throws RecognitionException {
		GlobalDescContext _localctx = new GlobalDescContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_globalDesc);
		try {
			setState(819);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(810);
				globalType();
				setState(811);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(813);
				inlineImport();
				setState(814);
				globalType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(816);
				inlineExport();
				setState(817);
				globalDesc();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDescContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode FUNC() { return getToken(WatParser.FUNC, 0); }
		public TypeUseContext typeUse() {
			return getRuleContext(TypeUseContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode GLOBAL() { return getToken(WatParser.GLOBAL, 0); }
		public GlobalTypeContext globalType() {
			return getRuleContext(GlobalTypeContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(WatParser.TABLE, 0); }
		public TableTypeContext tableType() {
			return getRuleContext(TableTypeContext.class,0);
		}
		public TerminalNode MEMORY() { return getToken(WatParser.MEMORY, 0); }
		public MemTypeContext memType() {
			return getRuleContext(MemTypeContext.class,0);
		}
		public ImportDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDesc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitImportDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDescContext importDesc() throws RecognitionException {
		ImportDescContext _localctx = new ImportDescContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_importDesc);
		int _la;
		try {
			setState(853);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(821);
				match(LEFT_PAREN);
				setState(822);
				match(FUNC);
				setState(824);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(823);
					id();
					}
				}

				setState(826);
				typeUse();
				setState(827);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(829);
				match(LEFT_PAREN);
				setState(830);
				match(GLOBAL);
				setState(832);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(831);
					id();
					}
				}

				setState(834);
				globalType();
				setState(835);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(837);
				match(LEFT_PAREN);
				setState(838);
				match(TABLE);
				setState(840);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(839);
					id();
					}
				}

				setState(842);
				tableType();
				setState(843);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(845);
				match(LEFT_PAREN);
				setState(846);
				match(MEMORY);
				setState(848);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(847);
					id();
					}
				}

				setState(850);
				memType();
				setState(851);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExportDescContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode FUNC() { return getToken(WatParser.FUNC, 0); }
		public FunctionIndexContext functionIndex() {
			return getRuleContext(FunctionIndexContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public TerminalNode GLOBAL() { return getToken(WatParser.GLOBAL, 0); }
		public GlobalIndexContext globalIndex() {
			return getRuleContext(GlobalIndexContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(WatParser.TABLE, 0); }
		public TableIndexContext tableIndex() {
			return getRuleContext(TableIndexContext.class,0);
		}
		public TerminalNode MEMORY() { return getToken(WatParser.MEMORY, 0); }
		public MemoryIndexContext memoryIndex() {
			return getRuleContext(MemoryIndexContext.class,0);
		}
		public ExportDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportDesc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitExportDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportDescContext exportDesc() throws RecognitionException {
		ExportDescContext _localctx = new ExportDescContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_exportDesc);
		try {
			setState(875);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(855);
				match(LEFT_PAREN);
				setState(856);
				match(FUNC);
				setState(857);
				functionIndex();
				setState(858);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(860);
				match(LEFT_PAREN);
				setState(861);
				match(GLOBAL);
				setState(862);
				globalIndex();
				setState(863);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(865);
				match(LEFT_PAREN);
				setState(866);
				match(TABLE);
				setState(867);
				tableIndex();
				setState(868);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(870);
				match(LEFT_PAREN);
				setState(871);
				match(MEMORY);
				setState(872);
				memoryIndex();
				setState(873);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElemListContext extends ParserRuleContext {
		public RefTypeContext refType() {
			return getRuleContext(RefTypeContext.class,0);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public TerminalNode FUNC() { return getToken(WatParser.FUNC, 0); }
		public List<FunctionIndexContext> functionIndex() {
			return getRuleContexts(FunctionIndexContext.class);
		}
		public FunctionIndexContext functionIndex(int i) {
			return getRuleContext(FunctionIndexContext.class,i);
		}
		public ElemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitElemList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElemListContext elemList() throws RecognitionException {
		ElemListContext _localctx = new ElemListContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_elemList);
		int _la;
		try {
			setState(891);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REF_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(877);
				refType();
				setState(881);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << NUM_LOAD) | (1L << NUM_STORE) | (1L << VEC_LOAD) | (1L << VEC_LOAD_LANE) | (1L << VEC_STORE) | (1L << VEC_STORE_LANE) | (1L << INT_CONST) | (1L << FLOAT_CONST) | (1L << NUM_INSTR) | (1L << VEC_CONST) | (1L << VEC_SHUFFLE) | (1L << VEC_LANE_INSTR) | (1L << VEC_INSTR) | (1L << BLOCK) | (1L << BR) | (1L << BR_IF) | (1L << BR_TABLE) | (1L << CALL) | (1L << CALL_INDIRECT) | (1L << DATA_DROP) | (1L << DROP) | (1L << ELEM_DROP) | (1L << GLOBAL_GET) | (1L << GLOBAL_SET) | (1L << IF) | (1L << LOCAL_GET) | (1L << LOCAL_SET) | (1L << LOCAL_TEE) | (1L << LOOP) | (1L << MEMORY_COPY) | (1L << MEMORY_FILL) | (1L << MEMORY_GROW) | (1L << MEMORY_INIT) | (1L << MEMORY_SIZE) | (1L << NOP))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (REF_FUNC - 65)) | (1L << (REF_IS_NULL - 65)) | (1L << (REF_NULL - 65)) | (1L << (RETURN - 65)) | (1L << (SELECT - 65)) | (1L << (TABLE_COPY - 65)) | (1L << (TABLE_FILL - 65)) | (1L << (TABLE_GET - 65)) | (1L << (TABLE_GROW - 65)) | (1L << (TABLE_INIT - 65)) | (1L << (TABLE_SET - 65)) | (1L << (TABLE_SIZE - 65)) | (1L << (UNREACHABLE - 65)))) != 0)) {
					{
					{
					setState(878);
					item();
					}
					}
					setState(883);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(884);
				match(FUNC);
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INTEGER || _la==ID) {
					{
					{
					setState(885);
					functionIndex();
					}
					}
					setState(890);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(WatParser.EOF, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<ModuleFieldContext> moduleField() {
			return getRuleContexts(ModuleFieldContext.class);
		}
		public ModuleFieldContext moduleField(int i) {
			return getRuleContext(ModuleFieldContext.class,i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_script);
		int _la;
		try {
			setState(907);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(896);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LEFT_PAREN) {
					{
					{
					setState(893);
					command();
					}
					}
					setState(898);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(899);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LEFT_PAREN) {
					{
					{
					setState(900);
					moduleField();
					}
					}
					setState(905);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(906);
				match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public ScriptModuleContext scriptModule() {
			return getRuleContext(ScriptModuleContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
		}
		public MetaContext meta() {
			return getRuleContext(MetaContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_command);
		try {
			setState(914);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(909);
				scriptModule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(910);
				register();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(911);
				action();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(912);
				assertion();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(913);
				meta();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptModuleContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode MODULE() { return getToken(WatParser.MODULE, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<ModuleFieldContext> moduleField() {
			return getRuleContexts(ModuleFieldContext.class);
		}
		public ModuleFieldContext moduleField(int i) {
			return getRuleContext(ModuleFieldContext.class,i);
		}
		public TerminalNode BINARY() { return getToken(WatParser.BINARY, 0); }
		public DataStringContext dataString() {
			return getRuleContext(DataStringContext.class,0);
		}
		public TerminalNode QUOTE() { return getToken(WatParser.QUOTE, 0); }
		public ScriptModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptModule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitScriptModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptModuleContext scriptModule() throws RecognitionException {
		ScriptModuleContext _localctx = new ScriptModuleContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_scriptModule);
		int _la;
		try {
			setState(946);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(916);
				match(LEFT_PAREN);
				setState(917);
				match(MODULE);
				setState(919);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(918);
					id();
					}
				}

				setState(924);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LEFT_PAREN) {
					{
					{
					setState(921);
					moduleField();
					}
					}
					setState(926);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(927);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(928);
				match(LEFT_PAREN);
				setState(929);
				match(MODULE);
				setState(931);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(930);
					id();
					}
				}

				setState(933);
				match(BINARY);
				setState(934);
				dataString();
				setState(935);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(937);
				match(LEFT_PAREN);
				setState(938);
				match(MODULE);
				setState(940);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(939);
					id();
					}
				}

				setState(942);
				match(QUOTE);
				setState(943);
				dataString();
				setState(944);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode INVOKE() { return getToken(WatParser.INVOKE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<ScriptConstContext> scriptConst() {
			return getRuleContexts(ScriptConstContext.class);
		}
		public ScriptConstContext scriptConst(int i) {
			return getRuleContext(ScriptConstContext.class,i);
		}
		public TerminalNode GET() { return getToken(WatParser.GET, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_action);
		int _la;
		try {
			setState(970);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(948);
				match(LEFT_PAREN);
				setState(949);
				match(INVOKE);
				setState(951);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(950);
					id();
					}
				}

				setState(953);
				name();
				setState(957);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LEFT_PAREN) {
					{
					{
					setState(954);
					scriptConst();
					}
					}
					setState(959);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(960);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(962);
				match(LEFT_PAREN);
				setState(963);
				match(GET);
				setState(965);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(964);
					id();
					}
				}

				setState(967);
				name();
				setState(968);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegisterContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode REGISTER() { return getToken(WatParser.REGISTER, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public RegisterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitRegister(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegisterContext register() throws RecognitionException {
		RegisterContext _localctx = new RegisterContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_register);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(972);
			match(LEFT_PAREN);
			setState(973);
			match(REGISTER);
			setState(974);
			name();
			setState(976);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(975);
				id();
				}
			}

			setState(978);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptConstContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode INT_CONST() { return getToken(WatParser.INT_CONST, 0); }
		public TerminalNode INTEGER() { return getToken(WatParser.INTEGER, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public TerminalNode FLOAT_CONST() { return getToken(WatParser.FLOAT_CONST, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode VEC_CONST() { return getToken(WatParser.VEC_CONST, 0); }
		public VecShapeContext vecShape() {
			return getRuleContext(VecShapeContext.class,0);
		}
		public TerminalNode REF_NULL() { return getToken(WatParser.REF_NULL, 0); }
		public HeapTypeContext heapType() {
			return getRuleContext(HeapTypeContext.class,0);
		}
		public TerminalNode REF_EXTERN() { return getToken(WatParser.REF_EXTERN, 0); }
		public ScriptConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptConst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitScriptConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptConstContext scriptConst() throws RecognitionException {
		ScriptConstContext _localctx = new ScriptConstContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_scriptConst);
		int _la;
		try {
			setState(1008);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(980);
				match(LEFT_PAREN);
				setState(981);
				match(INT_CONST);
				setState(982);
				match(INTEGER);
				setState(983);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(984);
				match(LEFT_PAREN);
				setState(985);
				match(FLOAT_CONST);
				setState(986);
				number();
				setState(987);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(989);
				match(LEFT_PAREN);
				setState(990);
				match(VEC_CONST);
				setState(991);
				vecShape();
				setState(993); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(992);
					number();
					}
					}
					setState(995); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INTEGER || _la==FLOAT );
				setState(997);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(999);
				match(LEFT_PAREN);
				setState(1000);
				match(REF_NULL);
				setState(1001);
				heapType();
				setState(1002);
				match(RIGHT_PAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1004);
				match(LEFT_PAREN);
				setState(1005);
				match(REF_EXTERN);
				setState(1006);
				match(INTEGER);
				setState(1007);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssertionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode ASSERT_RETURN() { return getToken(WatParser.ASSERT_RETURN, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public List<ScriptResultContext> scriptResult() {
			return getRuleContexts(ScriptResultContext.class);
		}
		public ScriptResultContext scriptResult(int i) {
			return getRuleContext(ScriptResultContext.class,i);
		}
		public TerminalNode ASSERT_TRAP() { return getToken(WatParser.ASSERT_TRAP, 0); }
		public DataStringContext dataString() {
			return getRuleContext(DataStringContext.class,0);
		}
		public TerminalNode ASSERT_EXHAUSTION() { return getToken(WatParser.ASSERT_EXHAUSTION, 0); }
		public TerminalNode ASSERT_MALFORMED() { return getToken(WatParser.ASSERT_MALFORMED, 0); }
		public ScriptModuleContext scriptModule() {
			return getRuleContext(ScriptModuleContext.class,0);
		}
		public TerminalNode ASSERT_INVALID() { return getToken(WatParser.ASSERT_INVALID, 0); }
		public TerminalNode ASSERT_UNLINKABLE() { return getToken(WatParser.ASSERT_UNLINKABLE, 0); }
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitAssertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_assertion);
		int _la;
		try {
			setState(1057);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1010);
				match(LEFT_PAREN);
				setState(1011);
				match(ASSERT_RETURN);
				setState(1012);
				action();
				setState(1016);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LEFT_PAREN) {
					{
					{
					setState(1013);
					scriptResult();
					}
					}
					setState(1018);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1019);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1021);
				match(LEFT_PAREN);
				setState(1022);
				match(ASSERT_TRAP);
				setState(1023);
				action();
				setState(1024);
				dataString();
				setState(1025);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1027);
				match(LEFT_PAREN);
				setState(1028);
				match(ASSERT_EXHAUSTION);
				setState(1029);
				action();
				setState(1030);
				dataString();
				setState(1031);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1033);
				match(LEFT_PAREN);
				setState(1034);
				match(ASSERT_MALFORMED);
				setState(1035);
				scriptModule();
				setState(1036);
				dataString();
				setState(1037);
				match(RIGHT_PAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1039);
				match(LEFT_PAREN);
				setState(1040);
				match(ASSERT_INVALID);
				setState(1041);
				scriptModule();
				setState(1042);
				dataString();
				setState(1043);
				match(RIGHT_PAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1045);
				match(LEFT_PAREN);
				setState(1046);
				match(ASSERT_UNLINKABLE);
				setState(1047);
				scriptModule();
				setState(1048);
				dataString();
				setState(1049);
				match(RIGHT_PAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1051);
				match(LEFT_PAREN);
				setState(1052);
				match(ASSERT_TRAP);
				setState(1053);
				scriptModule();
				setState(1054);
				dataString();
				setState(1055);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScriptResultContext extends ParserRuleContext {
		public ScriptConstContext scriptConst() {
			return getRuleContext(ScriptConstContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode INT_CONST() { return getToken(WatParser.INT_CONST, 0); }
		public List<NumPatContext> numPat() {
			return getRuleContexts(NumPatContext.class);
		}
		public NumPatContext numPat(int i) {
			return getRuleContext(NumPatContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public TerminalNode FLOAT_CONST() { return getToken(WatParser.FLOAT_CONST, 0); }
		public TerminalNode VEC_CONST() { return getToken(WatParser.VEC_CONST, 0); }
		public VecShapeContext vecShape() {
			return getRuleContext(VecShapeContext.class,0);
		}
		public TerminalNode REF_EXTERN() { return getToken(WatParser.REF_EXTERN, 0); }
		public TerminalNode REF_FUNC() { return getToken(WatParser.REF_FUNC, 0); }
		public ScriptResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptResult; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitScriptResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptResultContext scriptResult() throws RecognitionException {
		ScriptResultContext _localctx = new ScriptResultContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_scriptResult);
		int _la;
		try {
			setState(1086);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1059);
				scriptConst();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1060);
				match(LEFT_PAREN);
				setState(1061);
				match(INT_CONST);
				setState(1062);
				numPat();
				setState(1063);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1065);
				match(LEFT_PAREN);
				setState(1066);
				match(FLOAT_CONST);
				setState(1067);
				numPat();
				setState(1068);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1070);
				match(LEFT_PAREN);
				setState(1071);
				match(VEC_CONST);
				setState(1072);
				vecShape();
				setState(1074); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1073);
					numPat();
					}
					}
					setState(1076); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INTEGER || _la==FLOAT || _la==NAN_ARITHMETIC || _la==NAN_CANONICAL );
				setState(1078);
				match(RIGHT_PAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1080);
				match(LEFT_PAREN);
				setState(1081);
				match(REF_EXTERN);
				setState(1082);
				match(RIGHT_PAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1083);
				match(LEFT_PAREN);
				setState(1084);
				match(REF_FUNC);
				setState(1085);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumPatContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode NAN_CANONICAL() { return getToken(WatParser.NAN_CANONICAL, 0); }
		public TerminalNode NAN_ARITHMETIC() { return getToken(WatParser.NAN_ARITHMETIC, 0); }
		public NumPatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numPat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitNumPat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumPatContext numPat() throws RecognitionException {
		NumPatContext _localctx = new NumPatContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_numPat);
		try {
			setState(1091);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1088);
				number();
				}
				break;
			case NAN_CANONICAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1089);
				match(NAN_CANONICAL);
				}
				break;
			case NAN_ARITHMETIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(1090);
				match(NAN_ARITHMETIC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetaContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(WatParser.LEFT_PAREN, 0); }
		public TerminalNode SCRIPT() { return getToken(WatParser.SCRIPT, 0); }
		public ScriptContext script() {
			return getRuleContext(ScriptContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(WatParser.RIGHT_PAREN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode INPUT() { return getToken(WatParser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(WatParser.OUTPUT, 0); }
		public MetaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meta; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WatParserVisitor ) return ((WatParserVisitor<? extends T>)visitor).visitMeta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetaContext meta() throws RecognitionException {
		MetaContext _localctx = new MetaContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_meta);
		int _la;
		try {
			setState(1118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1093);
				match(LEFT_PAREN);
				setState(1094);
				match(SCRIPT);
				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(1095);
					id();
					}
				}

				setState(1098);
				script();
				setState(1099);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1101);
				match(LEFT_PAREN);
				setState(1102);
				match(INPUT);
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(1103);
					id();
					}
				}

				setState(1106);
				script();
				setState(1107);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1109);
				match(LEFT_PAREN);
				setState(1110);
				match(OUTPUT);
				setState(1112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(1111);
					id();
					}
				}

				setState(1115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOF || _la==LEFT_PAREN) {
					{
					setState(1114);
					script();
					}
				}

				setState(1117);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3h\u0463\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\7"+
		"\16\u00b6\n\16\f\16\16\16\u00b9\13\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\7\25\u00ca\n\25\f\25\16\25"+
		"\u00cd\13\25\3\25\7\25\u00d0\n\25\f\25\16\25\u00d3\13\25\3\25\3\25\3\26"+
		"\3\26\3\26\7\26\u00da\n\26\f\26\16\26\u00dd\13\26\3\26\3\26\3\27\3\27"+
		"\3\27\7\27\u00e4\n\27\f\27\16\27\u00e7\13\27\3\27\3\27\3\27\5\27\u00ec"+
		"\n\27\3\27\3\27\3\30\3\30\3\30\7\30\u00f3\n\30\f\30\16\30\u00f6\13\30"+
		"\3\30\3\30\3\30\5\30\u00fb\n\30\3\30\3\30\3\31\3\31\5\31\u0101\n\31\3"+
		"\32\3\32\5\32\u0105\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u010f\n\33\3\34\5\34\u0112\n\34\3\35\5\35\u0115\n\35\3\35\5\35\u0118"+
		"\n\35\3\36\5\36\u011b\n\36\3\36\5\36\u011e\n\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\5\37\u0126\n\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u012e\n\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0136\n\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u013e\n\37\3\37\3\37\3\37\5\37\u0143\n\37\5\37\u0145\n\37\3"+
		" \3 \3 \3 \3 \3 \3 \3 \5 \u014f\n \3!\3!\3!\3!\3!\3!\3!\3!\6!\u0159\n"+
		"!\r!\16!\u015a\3!\3!\3!\3!\3!\5!\u0162\n!\3!\5!\u0165\n!\3\"\3\"\3\"\3"+
		"\"\3\"\5\"\u016c\n\"\3#\3#\3#\7#\u0171\n#\f#\16#\u0174\13#\5#\u0176\n"+
		"#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0182\n$\3%\3%\5%\u0186\n%\3%\3%\5"+
		"%\u018a\n%\3%\3%\5%\u018e\n%\3%\3%\5%\u0192\n%\3%\3%\5%\u0196\n%\3%\3"+
		"%\3%\3%\5%\u019c\n%\3%\3%\5%\u01a0\n%\3%\3%\3%\5%\u01a5\n%\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u01bf"+
		"\n&\3\'\3\'\3\'\3\'\3\'\5\'\u01c6\n\'\3(\3(\3(\6(\u01cb\n(\r(\16(\u01cc"+
		"\3(\3(\6(\u01d1\n(\r(\16(\u01d2\3(\3(\3(\5(\u01d8\n(\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0201\n)\3)\3)\5)\u0205\n)\3*\7*\u0208"+
		"\n*\f*\16*\u020b\13*\3+\3+\3+\5+\u0210\n+\3+\7+\u0213\n+\f+\16+\u0216"+
		"\13+\3+\3+\3+\7+\u021b\n+\f+\16+\u021e\13+\3+\5+\u0221\n+\3,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\5,\u022d\n,\3-\3-\3-\5-\u0232\n-\3-\3-\3-\3.\3.\3."+
		"\5.\u023a\n.\3.\3.\3.\3/\3/\3/\5/\u0242\n/\3/\3/\3/\3\60\3\60\3\60\5\60"+
		"\u024a\n\60\3\60\3\60\3\60\3\61\3\61\3\61\5\61\u0252\n\61\3\61\3\61\3"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\5\65\u026c\n\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\5\65\u0274\n\65\3\65\5\65\u0277\n\65\3\65\3\65\3\65\3"+
		"\65\3\65\3\65\3\65\5\65\u0280\n\65\3\65\3\65\7\65\u0284\n\65\f\65\16\65"+
		"\u0287\13\65\3\65\3\65\3\65\3\65\3\65\5\65\u028e\n\65\3\65\3\65\3\65\3"+
		"\65\5\65\u0294\n\65\3\66\3\66\3\66\5\66\u0299\n\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\5\66\u02a1\n\66\3\66\5\66\u02a4\n\66\3\66\3\66\3\66\3\66\5"+
		"\66\u02aa\n\66\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u02b2\n\67\38\38\38"+
		"\38\38\38\58\u02ba\n8\39\39\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;"+
		"\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\7=\u02d6\n=\f=\16=\u02d9\13=\3=\7=\u02dc"+
		"\n=\f=\16=\u02df\13=\3=\7=\u02e2\n=\f=\16=\u02e5\13=\3=\7=\u02e8\n=\f"+
		"=\16=\u02eb\13=\5=\u02ed\n=\3>\3>\7>\u02f1\n>\f>\16>\u02f4\13>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\5>\u02fe\n>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\7?\u030b"+
		"\n?\f?\16?\u030e\13?\3?\3?\3?\3?\3?\3?\7?\u0316\n?\f?\16?\u0319\13?\3"+
		"?\3?\5?\u031d\n?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u032b\n@\3A\3"+
		"A\3A\3A\3A\3A\3A\3A\3A\5A\u0336\nA\3B\3B\3B\5B\u033b\nB\3B\3B\3B\3B\3"+
		"B\3B\5B\u0343\nB\3B\3B\3B\3B\3B\3B\5B\u034b\nB\3B\3B\3B\3B\3B\3B\5B\u0353"+
		"\nB\3B\3B\3B\5B\u0358\nB\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C"+
		"\3C\3C\3C\3C\3C\5C\u036e\nC\3D\3D\7D\u0372\nD\fD\16D\u0375\13D\3D\3D\7"+
		"D\u0379\nD\fD\16D\u037c\13D\5D\u037e\nD\3E\7E\u0381\nE\fE\16E\u0384\13"+
		"E\3E\3E\7E\u0388\nE\fE\16E\u038b\13E\3E\5E\u038e\nE\3F\3F\3F\3F\3F\5F"+
		"\u0395\nF\3G\3G\3G\5G\u039a\nG\3G\7G\u039d\nG\fG\16G\u03a0\13G\3G\3G\3"+
		"G\3G\5G\u03a6\nG\3G\3G\3G\3G\3G\3G\3G\5G\u03af\nG\3G\3G\3G\3G\5G\u03b5"+
		"\nG\3H\3H\3H\5H\u03ba\nH\3H\3H\7H\u03be\nH\fH\16H\u03c1\13H\3H\3H\3H\3"+
		"H\3H\5H\u03c8\nH\3H\3H\3H\5H\u03cd\nH\3I\3I\3I\3I\5I\u03d3\nI\3I\3I\3"+
		"J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\6J\u03e4\nJ\rJ\16J\u03e5\3J\3J\3"+
		"J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u03f3\nJ\3K\3K\3K\3K\7K\u03f9\nK\fK\16K\u03fc"+
		"\13K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3"+
		"K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\5K\u0424\nK\3L\3L\3"+
		"L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\6L\u0435\nL\rL\16L\u0436\3L\3L\3"+
		"L\3L\3L\3L\3L\3L\5L\u0441\nL\3M\3M\3M\5M\u0446\nM\3N\3N\3N\5N\u044b\n"+
		"N\3N\3N\3N\3N\3N\3N\5N\u0453\nN\3N\3N\3N\3N\3N\3N\5N\u045b\nN\3N\5N\u045e"+
		"\nN\3N\5N\u0461\nN\3N\2\2O\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\2\6"+
		"\4\2\5\5\b\b\3\2\5\6\3\2+,\3\2\t\13\2\u04da\2\u009c\3\2\2\2\4\u009e\3"+
		"\2\2\2\6\u00a0\3\2\2\2\b\u00a2\3\2\2\2\n\u00a4\3\2\2\2\f\u00a6\3\2\2\2"+
		"\16\u00a8\3\2\2\2\20\u00aa\3\2\2\2\22\u00ac\3\2\2\2\24\u00ae\3\2\2\2\26"+
		"\u00b0\3\2\2\2\30\u00b2\3\2\2\2\32\u00b7\3\2\2\2\34\u00ba\3\2\2\2\36\u00bc"+
		"\3\2\2\2 \u00be\3\2\2\2\"\u00c0\3\2\2\2$\u00c2\3\2\2\2&\u00c4\3\2\2\2"+
		"(\u00c6\3\2\2\2*\u00d6\3\2\2\2,\u00e0\3\2\2\2.\u00ef\3\2\2\2\60\u00fe"+
		"\3\2\2\2\62\u0102\3\2\2\2\64\u010e\3\2\2\2\66\u0111\3\2\2\28\u0117\3\2"+
		"\2\2:\u011a\3\2\2\2<\u0144\3\2\2\2>\u014e\3\2\2\2@\u0164\3\2\2\2B\u016b"+
		"\3\2\2\2D\u0175\3\2\2\2F\u0181\3\2\2\2H\u01a4\3\2\2\2J\u01be\3\2\2\2L"+
		"\u01c5\3\2\2\2N\u01d7\3\2\2\2P\u0204\3\2\2\2R\u0209\3\2\2\2T\u0220\3\2"+
		"\2\2V\u022c\3\2\2\2X\u022e\3\2\2\2Z\u0236\3\2\2\2\\\u023e\3\2\2\2^\u0246"+
		"\3\2\2\2`\u024e\3\2\2\2b\u0256\3\2\2\2d\u025d\3\2\2\2f\u0263\3\2\2\2h"+
		"\u0293\3\2\2\2j\u02a9\3\2\2\2l\u02b1\3\2\2\2n\u02b9\3\2\2\2p\u02bb\3\2"+
		"\2\2r\u02c1\3\2\2\2t\u02c6\3\2\2\2v\u02cb\3\2\2\2x\u02ec\3\2\2\2z\u02fd"+
		"\3\2\2\2|\u031c\3\2\2\2~\u032a\3\2\2\2\u0080\u0335\3\2\2\2\u0082\u0357"+
		"\3\2\2\2\u0084\u036d\3\2\2\2\u0086\u037d\3\2\2\2\u0088\u038d\3\2\2\2\u008a"+
		"\u0394\3\2\2\2\u008c\u03b4\3\2\2\2\u008e\u03cc\3\2\2\2\u0090\u03ce\3\2"+
		"\2\2\u0092\u03f2\3\2\2\2\u0094\u0423\3\2\2\2\u0096\u0440\3\2\2\2\u0098"+
		"\u0445\3\2\2\2\u009a\u0460\3\2\2\2\u009c\u009d\7\b\2\2\u009d\3\3\2\2\2"+
		"\u009e\u009f\t\2\2\2\u009f\5\3\2\2\2\u00a0\u00a1\5\4\3\2\u00a1\7\3\2\2"+
		"\2\u00a2\u00a3\5\4\3\2\u00a3\t\3\2\2\2\u00a4\u00a5\5\4\3\2\u00a5\13\3"+
		"\2\2\2\u00a6\u00a7\5\4\3\2\u00a7\r\3\2\2\2\u00a8\u00a9\5\4\3\2\u00a9\17"+
		"\3\2\2\2\u00aa\u00ab\5\4\3\2\u00ab\21\3\2\2\2\u00ac\u00ad\5\4\3\2\u00ad"+
		"\23\3\2\2\2\u00ae\u00af\5\4\3\2\u00af\25\3\2\2\2\u00b0\u00b1\5\4\3\2\u00b1"+
		"\27\3\2\2\2\u00b2\u00b3\7\7\2\2\u00b3\31\3\2\2\2\u00b4\u00b6\7\7\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\33\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\t\3\2\2\u00bb\35"+
		"\3\2\2\2\u00bc\u00bd\7\13\2\2\u00bd\37\3\2\2\2\u00be\u00bf\t\4\2\2\u00bf"+
		"!\3\2\2\2\u00c0\u00c1\t\5\2\2\u00c1#\3\2\2\2\u00c2\u00c3\7\n\2\2\u00c3"+
		"%\3\2\2\2\u00c4\u00c5\7\f\2\2\u00c5\'\3\2\2\2\u00c6\u00c7\7\3\2\2\u00c7"+
		"\u00cb\7,\2\2\u00c8\u00ca\5,\27\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d1\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00d0\5*\26\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00d5\7\4\2\2\u00d5)\3\2\2\2\u00d6\u00d7\7\3\2\2"+
		"\u00d7\u00db\7F\2\2\u00d8\u00da\5\"\22\2\u00d9\u00d8\3\2\2\2\u00da\u00dd"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00df\7\4\2\2\u00df+\3\2\2\2\u00e0\u00e1\7\3\2\2"+
		"\u00e1\u00eb\7B\2\2\u00e2\u00e4\5\"\22\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00ec\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00e9\5\2\2\2\u00e9\u00ea\5\"\22\2\u00ea\u00ec\3"+
		"\2\2\2\u00eb\u00e5\3\2\2\2\u00eb\u00e8\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ee\7\4\2\2\u00ee-\3\2\2\2\u00ef\u00f0\7\3\2\2\u00f0\u00fa\7\63\2\2"+
		"\u00f1\u00f3\5\"\22\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2"+
		"\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00fb\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7"+
		"\u00f8\5\2\2\2\u00f8\u00f9\5\"\22\2\u00f9\u00fb\3\2\2\2\u00fa\u00f4\3"+
		"\2\2\2\u00fa\u00f7\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7\4\2\2\u00fd"+
		"/\3\2\2\2\u00fe\u0100\7\5\2\2\u00ff\u0101\7\5\2\2\u0100\u00ff\3\2\2\2"+
		"\u0100\u0101\3\2\2\2\u0101\61\3\2\2\2\u0102\u0104\7\5\2\2\u0103\u0105"+
		"\7\5\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0107\5\36\20\2\u0107\63\3\2\2\2\u0108\u010f\5\"\22\2\u0109\u010a\7\3"+
		"\2\2\u010a\u010b\7?\2\2\u010b\u010c\5\"\22\2\u010c\u010d\7\4\2\2\u010d"+
		"\u010f\3\2\2\2\u010e\u0108\3\2\2\2\u010e\u0109\3\2\2\2\u010f\65\3\2\2"+
		"\2\u0110\u0112\7\b\2\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\67"+
		"\3\2\2\2\u0113\u0115\5*\26\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0118\3\2\2\2\u0116\u0118\5x=\2\u0117\u0114\3\2\2\2\u0117\u0116\3\2\2"+
		"\2\u01189\3\2\2\2\u0119\u011b\7\23\2\2\u011a\u0119\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011e\7\24\2\2\u011d\u011c\3\2\2\2"+
		"\u011d\u011e\3\2\2\2\u011e;\3\2\2\2\u011f\u0120\7\34\2\2\u0120\u0121\5"+
		"\66\34\2\u0121\u0122\58\35\2\u0122\u0123\5R*\2\u0123\u0125\7)\2\2\u0124"+
		"\u0126\5\2\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0145\3\2"+
		"\2\2\u0127\u0128\7\67\2\2\u0128\u0129\5\66\34\2\u0129\u012a\58\35\2\u012a"+
		"\u012b\5R*\2\u012b\u012d\7)\2\2\u012c\u012e\5\2\2\2\u012d\u012c\3\2\2"+
		"\2\u012d\u012e\3\2\2\2\u012e\u0145\3\2\2\2\u012f\u0130\7\60\2\2\u0130"+
		"\u0131\5\66\34\2\u0131\u0132\58\35\2\u0132\u0133\5R*\2\u0133\u0135\7)"+
		"\2\2\u0134\u0136\5\2\2\2\u0135\u0134\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0145\3\2\2\2\u0137\u0138\7\60\2\2\u0138\u0139\5\66\34\2\u0139\u013a"+
		"\58\35\2\u013a\u013b\5R*\2\u013b\u013d\7(\2\2\u013c\u013e\5\2\2\2\u013d"+
		"\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\5R"+
		"*\2\u0140\u0142\7)\2\2\u0141\u0143\5\2\2\2\u0142\u0141\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u011f\3\2\2\2\u0144\u0127\3\2\2\2\u0144"+
		"\u012f\3\2\2\2\u0144\u0137\3\2\2\2\u0145=\3\2\2\2\u0146\u014f\5@!\2\u0147"+
		"\u014f\5B\"\2\u0148\u014f\5D#\2\u0149\u014f\5F$\2\u014a\u014f\5H%\2\u014b"+
		"\u014f\5J&\2\u014c\u014f\5L\'\2\u014d\u014f\5N(\2\u014e\u0146\3\2\2\2"+
		"\u014e\u0147\3\2\2\2\u014e\u0148\3\2\2\2\u014e\u0149\3\2\2\2\u014e\u014a"+
		"\3\2\2\2\u014e\u014b\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014d\3\2\2\2\u014f"+
		"?\3\2\2\2\u0150\u0165\7T\2\2\u0151\u0165\7@\2\2\u0152\u0153\7\35\2\2\u0153"+
		"\u0165\5\26\f\2\u0154\u0155\7\36\2\2\u0155\u0165\5\26\f\2\u0156\u0158"+
		"\7\37\2\2\u0157\u0159\5\26\f\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2"+
		"\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0165\3\2\2\2\u015c\u0165"+
		"\7G\2\2\u015d\u015e\7 \2\2\u015e\u0165\5\b\5\2\u015f\u0161\7!\2\2\u0160"+
		"\u0162\5\n\6\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0165\5x=\2\u0164\u0150\3\2\2\2\u0164\u0151\3\2\2\2\u0164\u0152"+
		"\3\2\2\2\u0164\u0154\3\2\2\2\u0164\u0156\3\2\2\2\u0164\u015c\3\2\2\2\u0164"+
		"\u015d\3\2\2\2\u0164\u015f\3\2\2\2\u0165A\3\2\2\2\u0166\u0167\7E\2\2\u0167"+
		"\u016c\5 \21\2\u0168\u016c\7D\2\2\u0169\u016a\7C\2\2\u016a\u016c\5\b\5"+
		"\2\u016b\u0166\3\2\2\2\u016b\u0168\3\2\2\2\u016b\u0169\3\2\2\2\u016cC"+
		"\3\2\2\2\u016d\u0176\7%\2\2\u016e\u0172\7H\2\2\u016f\u0171\5*\26\2\u0170"+
		"\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u016d\3\2\2\2\u0175"+
		"\u016e\3\2\2\2\u0176E\3\2\2\2\u0177\u0178\7\64\2\2\u0178\u0182\5\24\13"+
		"\2\u0179\u017a\7\65\2\2\u017a\u0182\5\24\13\2\u017b\u017c\7\66\2\2\u017c"+
		"\u0182\5\24\13\2\u017d\u017e\7.\2\2\u017e\u0182\5\16\b\2\u017f\u0180\7"+
		"/\2\2\u0180\u0182\5\16\b\2\u0181\u0177\3\2\2\2\u0181\u0179\3\2\2\2\u0181"+
		"\u017b\3\2\2\2\u0181\u017d\3\2\2\2\u0181\u017f\3\2\2\2\u0182G\3\2\2\2"+
		"\u0183\u0185\7M\2\2\u0184\u0186\5\n\6\2\u0185\u0184\3\2\2\2\u0185\u0186"+
		"\3\2\2\2\u0186\u01a5\3\2\2\2\u0187\u0189\7P\2\2\u0188\u018a\5\n\6\2\u0189"+
		"\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u01a5\3\2\2\2\u018b\u018d\7Q"+
		"\2\2\u018c\u018e\5\n\6\2\u018d\u018c\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u01a5\3\2\2\2\u018f\u0191\7N\2\2\u0190\u0192\5\n\6\2\u0191\u0190\3\2"+
		"\2\2\u0191\u0192\3\2\2\2\u0192\u01a5\3\2\2\2\u0193\u0195\7L\2\2\u0194"+
		"\u0196\5\n\6\2\u0195\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u01a5\3\2"+
		"\2\2\u0197\u019b\7K\2\2\u0198\u0199\5\n\6\2\u0199\u019a\5\n\6\2\u019a"+
		"\u019c\3\2\2\2\u019b\u0198\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u01a5\3\2"+
		"\2\2\u019d\u019f\7O\2\2\u019e\u01a0\5\n\6\2\u019f\u019e\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a5\5\20\t\2\u01a2\u01a3\7"+
		"\'\2\2\u01a3\u01a5\5\20\t\2\u01a4\u0183\3\2\2\2\u01a4\u0187\3\2\2\2\u01a4"+
		"\u018b\3\2\2\2\u01a4\u018f\3\2\2\2\u01a4\u0193\3\2\2\2\u01a4\u0197\3\2"+
		"\2\2\u01a4\u019d\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5I\3\2\2\2\u01a6\u01a7"+
		"\7\r\2\2\u01a7\u01bf\5:\36\2\u01a8\u01a9\7\16\2\2\u01a9\u01bf\5:\36\2"+
		"\u01aa\u01ab\7\17\2\2\u01ab\u01bf\5:\36\2\u01ac\u01ad\7\21\2\2\u01ad\u01bf"+
		"\5:\36\2\u01ae\u01af\7\20\2\2\u01af\u01b0\5:\36\2\u01b0\u01b1\7\5\2\2"+
		"\u01b1\u01bf\3\2\2\2\u01b2\u01b3\7\22\2\2\u01b3\u01b4\5:\36\2\u01b4\u01b5"+
		"\7\5\2\2\u01b5\u01bf\3\2\2\2\u01b6\u01bf\7=\2\2\u01b7\u01bf\7;\2\2\u01b8"+
		"\u01bf\7:\2\2\u01b9\u01bf\79\2\2\u01ba\u01bb\7<\2\2\u01bb\u01bf\5\22\n"+
		"\2\u01bc\u01bd\7#\2\2\u01bd\u01bf\5\22\n\2\u01be\u01a6\3\2\2\2\u01be\u01a8"+
		"\3\2\2\2\u01be\u01aa\3\2\2\2\u01be\u01ac\3\2\2\2\u01be\u01ae\3\2\2\2\u01be"+
		"\u01b2\3\2\2\2\u01be\u01b6\3\2\2\2\u01be\u01b7\3\2\2\2\u01be\u01b8\3\2"+
		"\2\2\u01be\u01b9\3\2\2\2\u01be\u01ba\3\2\2\2\u01be\u01bc\3\2\2\2\u01bf"+
		"K\3\2\2\2\u01c0\u01c1\7\25\2\2\u01c1\u01c6\7\5\2\2\u01c2\u01c3\7\26\2"+
		"\2\u01c3\u01c6\5\34\17\2\u01c4\u01c6\7\27\2\2\u01c5\u01c0\3\2\2\2\u01c5"+
		"\u01c2\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6M\3\2\2\2\u01c7\u01c8\7\30\2\2"+
		"\u01c8\u01ca\5&\24\2\u01c9\u01cb\5\34\17\2\u01ca\u01c9\3\2\2\2\u01cb\u01cc"+
		"\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d8\3\2\2\2\u01ce"+
		"\u01d0\7\31\2\2\u01cf\u01d1\7\5\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d2\3"+
		"\2\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d8\3\2\2\2\u01d4"+
		"\u01d5\7\32\2\2\u01d5\u01d8\7\5\2\2\u01d6\u01d8\7\33\2\2\u01d7\u01c7\3"+
		"\2\2\2\u01d7\u01ce\3\2\2\2\u01d7\u01d4\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8"+
		"O\3\2\2\2\u01d9\u0205\5> \2\u01da\u0205\5<\37\2\u01db\u01dc\7\3\2\2\u01dc"+
		"\u01dd\5<\37\2\u01dd\u01de\7\4\2\2\u01de\u0205\3\2\2\2\u01df\u01e0\7\3"+
		"\2\2\u01e0\u01e1\5> \2\u01e1\u01e2\5R*\2\u01e2\u01e3\7\4\2\2\u01e3\u0205"+
		"\3\2\2\2\u01e4\u01e5\7\3\2\2\u01e5\u01e6\7\34\2\2\u01e6\u01e7\5\66\34"+
		"\2\u01e7\u01e8\58\35\2\u01e8\u01e9\5R*\2\u01e9\u01ea\7\4\2\2\u01ea\u0205"+
		"\3\2\2\2\u01eb\u01ec\7\3\2\2\u01ec\u01ed\7\67\2\2\u01ed\u01ee\5\66\34"+
		"\2\u01ee\u01ef\58\35\2\u01ef\u01f0\5R*\2\u01f0\u01f1\7\4\2\2\u01f1\u0205"+
		"\3\2\2\2\u01f2\u01f3\7\3\2\2\u01f3\u01f4\7\60\2\2\u01f4\u01f5\5\66\34"+
		"\2\u01f5\u01f6\58\35\2\u01f6\u01f7\5R*\2\u01f7\u01f8\7\3\2\2\u01f8\u01f9"+
		"\7R\2\2\u01f9\u01fa\5R*\2\u01fa\u0200\7\4\2\2\u01fb\u01fc\7\3\2\2\u01fc"+
		"\u01fd\7(\2\2\u01fd\u01fe\5R*\2\u01fe\u01ff\7\4\2\2\u01ff\u0201\3\2\2"+
		"\2\u0200\u01fb\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0203"+
		"\7\4\2\2\u0203\u0205\3\2\2\2\u0204\u01d9\3\2\2\2\u0204\u01da\3\2\2\2\u0204"+
		"\u01db\3\2\2\2\u0204\u01df\3\2\2\2\u0204\u01e4\3\2\2\2\u0204\u01eb\3\2"+
		"\2\2\u0204\u01f2\3\2\2\2\u0205Q\3\2\2\2\u0206\u0208\5P)\2\u0207\u0206"+
		"\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"S\3\2\2\2\u020b\u0209\3\2\2\2\u020c\u020d\7\3\2\2\u020d\u020f\7>\2\2\u020e"+
		"\u0210\5\2\2\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0214\3\2"+
		"\2\2\u0211\u0213\5V,\2\u0212\u0211\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212"+
		"\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0217\3\2\2\2\u0216\u0214\3\2\2\2\u0217"+
		"\u0218\7\4\2\2\u0218\u0221\7\2\2\3\u0219\u021b\5V,\2\u021a\u0219\3\2\2"+
		"\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021f"+
		"\3\2\2\2\u021e\u021c\3\2\2\2\u021f\u0221\7\2\2\3\u0220\u020c\3\2\2\2\u0220"+
		"\u021c\3\2\2\2\u0221U\3\2\2\2\u0222\u022d\5X-\2\u0223\u022d\5b\62\2\u0224"+
		"\u022d\5Z.\2\u0225\u022d\5\\/\2\u0226\u022d\5^\60\2\u0227\u022d\5`\61"+
		"\2\u0228\u022d\5d\63\2\u0229\u022d\5f\64\2\u022a\u022d\5h\65\2\u022b\u022d"+
		"\5j\66\2\u022c\u0222\3\2\2\2\u022c\u0223\3\2\2\2\u022c\u0224\3\2\2\2\u022c"+
		"\u0225\3\2\2\2\u022c\u0226\3\2\2\2\u022c\u0227\3\2\2\2\u022c\u0228\3\2"+
		"\2\2\u022c\u0229\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022b\3\2\2\2\u022d"+
		"W\3\2\2\2\u022e\u022f\7\3\2\2\u022f\u0231\7S\2\2\u0230\u0232\5\2\2\2\u0231"+
		"\u0230\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0234\5("+
		"\25\2\u0234\u0235\7\4\2\2\u0235Y\3\2\2\2\u0236\u0237\7\3\2\2\u0237\u0239"+
		"\7,\2\2\u0238\u023a\5\2\2\2\u0239\u0238\3\2\2\2\u0239\u023a\3\2\2\2\u023a"+
		"\u023b\3\2\2\2\u023b\u023c\5z>\2\u023c\u023d\7\4\2\2\u023d[\3\2\2\2\u023e"+
		"\u023f\7\3\2\2\u023f\u0241\7J\2\2\u0240\u0242\5\2\2\2\u0241\u0240\3\2"+
		"\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0244\5|?\2\u0244\u0245"+
		"\7\4\2\2\u0245]\3\2\2\2\u0246\u0247\7\3\2\2\u0247\u0249\78\2\2\u0248\u024a"+
		"\5\2\2\2\u0249\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b\3\2\2\2\u024b"+
		"\u024c\5~@\2\u024c\u024d\7\4\2\2\u024d_\3\2\2\2\u024e\u024f\7\3\2\2\u024f"+
		"\u0251\7-\2\2\u0250\u0252\5\2\2\2\u0251\u0250\3\2\2\2\u0251\u0252\3\2"+
		"\2\2\u0252\u0253\3\2\2\2\u0253\u0254\5\u0080A\2\u0254\u0255\7\4\2\2\u0255"+
		"a\3\2\2\2\u0256\u0257\7\3\2\2\u0257\u0258\7\61\2\2\u0258\u0259\5\30\r"+
		"\2\u0259\u025a\5\30\r\2\u025a\u025b\5\u0082B\2\u025b\u025c\7\4\2\2\u025c"+
		"c\3\2\2\2\u025d\u025e\7\3\2\2\u025e\u025f\7*\2\2\u025f\u0260\5\30\r\2"+
		"\u0260\u0261\5\u0084C\2\u0261\u0262\7\4\2\2\u0262e\3\2\2\2\u0263\u0264"+
		"\7\3\2\2\u0264\u0265\7I\2\2\u0265\u0266\5\b\5\2\u0266\u0267\7\4\2\2\u0267"+
		"g\3\2\2\2\u0268\u0269\7\3\2\2\u0269\u026b\7&\2\2\u026a\u026c\5\2\2\2\u026b"+
		"\u026a\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\5\u0086"+
		"D\2\u026e\u026f\7\4\2\2\u026f\u0294\3\2\2\2\u0270\u0271\7\3\2\2\u0271"+
		"\u0273\7&\2\2\u0272\u0274\5\2\2\2\u0273\u0272\3\2\2\2\u0273\u0274\3\2"+
		"\2\2\u0274\u0276\3\2\2\2\u0275\u0277\5v<\2\u0276\u0275\3\2\2\2\u0276\u0277"+
		"\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\5l\67\2\u0279\u027a\5\u0086D"+
		"\2\u027a\u027b\7\4\2\2\u027b\u0294\3\2\2\2\u027c\u027d\7\3\2\2\u027d\u027f"+
		"\7&\2\2\u027e\u0280\5\2\2\2\u027f\u027e\3\2\2\2\u027f\u0280\3\2\2\2\u0280"+
		"\u0281\3\2\2\2\u0281\u0285\5l\67\2\u0282\u0284\5\b\5\2\u0283\u0282\3\2"+
		"\2\2\u0284\u0287\3\2\2\2\u0285\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286"+
		"\u0288\3\2\2\2\u0287\u0285\3\2\2\2\u0288\u0289\7\4\2\2\u0289\u0294\3\2"+
		"\2\2\u028a\u028b\7\3\2\2\u028b\u028d\7&\2\2\u028c\u028e\5\2\2\2\u028d"+
		"\u028c\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0290\7$"+
		"\2\2\u0290\u0291\5\u0086D\2\u0291\u0292\7\4\2\2\u0292\u0294\3\2\2\2\u0293"+
		"\u0268\3\2\2\2\u0293\u0270\3\2\2\2\u0293\u027c\3\2\2\2\u0293\u028a\3\2"+
		"\2\2\u0294i\3\2\2\2\u0295\u0296\7\3\2\2\u0296\u0298\7\"\2\2\u0297\u0299"+
		"\5\2\2\2\u0298\u0297\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029a\3\2\2\2\u029a"+
		"\u029b\5\32\16\2\u029b\u029c\7\4\2\2\u029c\u02aa\3\2\2\2\u029d\u029e\7"+
		"\3\2\2\u029e\u02a0\7\"\2\2\u029f\u02a1\5\2\2\2\u02a0\u029f\3\2\2\2\u02a0"+
		"\u02a1\3\2\2\2\u02a1\u02a3\3\2\2\2\u02a2\u02a4\5t;\2\u02a3\u02a2\3\2\2"+
		"\2\u02a3\u02a4\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a6\5l\67\2\u02a6\u02a7"+
		"\5\32\16\2\u02a7\u02a8\7\4\2\2\u02a8\u02aa\3\2\2\2\u02a9\u0295\3\2\2\2"+
		"\u02a9\u029d\3\2\2\2\u02aak\3\2\2\2\u02ab\u02ac\7\3\2\2\u02ac\u02ad\7"+
		"A\2\2\u02ad\u02ae\5R*\2\u02ae\u02af\7\4\2\2\u02af\u02b2\3\2\2\2\u02b0"+
		"\u02b2\5P)\2\u02b1\u02ab\3\2\2\2\u02b1\u02b0\3\2\2\2\u02b2m\3\2\2\2\u02b3"+
		"\u02b4\7\3\2\2\u02b4\u02b5\7\62\2\2\u02b5\u02b6\5R*\2\u02b6\u02b7\7\4"+
		"\2\2\u02b7\u02ba\3\2\2\2\u02b8\u02ba\5P)\2\u02b9\u02b3\3\2\2\2\u02b9\u02b8"+
		"\3\2\2\2\u02bao\3\2\2\2\u02bb\u02bc\7\3\2\2\u02bc\u02bd\7\61\2\2\u02bd"+
		"\u02be\5\30\r\2\u02be\u02bf\5\30\r\2\u02bf\u02c0\7\4\2\2\u02c0q\3\2\2"+
		"\2\u02c1\u02c2\7\3\2\2\u02c2\u02c3\7*\2\2\u02c3\u02c4\5\30\r\2\u02c4\u02c5"+
		"\7\4\2\2\u02c5s\3\2\2\2\u02c6\u02c7\7\3\2\2\u02c7\u02c8\78\2\2\u02c8\u02c9"+
		"\5\f\7\2\u02c9\u02ca\7\4\2\2\u02cau\3\2\2\2\u02cb\u02cc\7\3\2\2\u02cc"+
		"\u02cd\7J\2\2\u02cd\u02ce\5\n\6\2\u02ce\u02cf\7\4\2\2\u02cfw\3\2\2\2\u02d0"+
		"\u02d1\7\3\2\2\u02d1\u02d2\7S\2\2\u02d2\u02d3\5\6\4\2\u02d3\u02d7\7\4"+
		"\2\2\u02d4\u02d6\5,\27\2\u02d5\u02d4\3\2\2\2\u02d6\u02d9\3\2\2\2\u02d7"+
		"\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02dd\3\2\2\2\u02d9\u02d7\3\2"+
		"\2\2\u02da\u02dc\5*\26\2\u02db\u02da\3\2\2\2\u02dc\u02df\3\2\2\2\u02dd"+
		"\u02db\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02ed\3\2\2\2\u02df\u02dd\3\2"+
		"\2\2\u02e0\u02e2\5,\27\2\u02e1\u02e0\3\2\2\2\u02e2\u02e5\3\2\2\2\u02e3"+
		"\u02e1\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e9\3\2\2\2\u02e5\u02e3\3\2"+
		"\2\2\u02e6\u02e8\5*\26\2\u02e7\u02e6\3\2\2\2\u02e8\u02eb\3\2\2\2\u02e9"+
		"\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02ed\3\2\2\2\u02eb\u02e9\3\2"+
		"\2\2\u02ec\u02d0\3\2\2\2\u02ec\u02e3\3\2\2\2\u02edy\3\2\2\2\u02ee\u02f2"+
		"\5x=\2\u02ef\u02f1\5.\30\2\u02f0\u02ef\3\2\2\2\u02f1\u02f4\3\2\2\2\u02f2"+
		"\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f5\3\2\2\2\u02f4\u02f2\3\2"+
		"\2\2\u02f5\u02f6\5R*\2\u02f6\u02fe\3\2\2\2\u02f7\u02f8\5p9\2\u02f8\u02f9"+
		"\5x=\2\u02f9\u02fe\3\2\2\2\u02fa\u02fb\5r:\2\u02fb\u02fc\5z>\2\u02fc\u02fe"+
		"\3\2\2\2\u02fd\u02ee\3\2\2\2\u02fd\u02f7\3\2\2\2\u02fd\u02fa\3\2\2\2\u02fe"+
		"{\3\2\2\2\u02ff\u031d\5\62\32\2\u0300\u0301\5p9\2\u0301\u0302\5\62\32"+
		"\2\u0302\u031d\3\2\2\2\u0303\u0304\5r:\2\u0304\u0305\5|?\2\u0305\u031d"+
		"\3\2\2\2\u0306\u0307\5\36\20\2\u0307\u0308\7\3\2\2\u0308\u030c\7&\2\2"+
		"\u0309\u030b\5n8\2\u030a\u0309\3\2\2\2\u030b\u030e\3\2\2\2\u030c\u030a"+
		"\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030f\3\2\2\2\u030e\u030c\3\2\2\2\u030f"+
		"\u0310\7\4\2\2\u0310\u031d\3\2\2\2\u0311\u0312\5\36\20\2\u0312\u0313\7"+
		"\3\2\2\u0313\u0317\7&\2\2\u0314\u0316\5\b\5\2\u0315\u0314\3\2\2\2\u0316"+
		"\u0319\3\2\2\2\u0317\u0315\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u031a\3\2"+
		"\2\2\u0319\u0317\3\2\2\2\u031a\u031b\7\4\2\2\u031b\u031d\3\2\2\2\u031c"+
		"\u02ff\3\2\2\2\u031c\u0300\3\2\2\2\u031c\u0303\3\2\2\2\u031c\u0306\3\2"+
		"\2\2\u031c\u0311\3\2\2\2\u031d}\3\2\2\2\u031e\u032b\5\60\31\2\u031f\u0320"+
		"\5p9\2\u0320\u0321\5\60\31\2\u0321\u032b\3\2\2\2\u0322\u0323\5r:\2\u0323"+
		"\u0324\5~@\2\u0324\u032b\3\2\2\2\u0325\u0326\7\3\2\2\u0326\u0327\7\"\2"+
		"\2\u0327\u0328\5\32\16\2\u0328\u0329\7\4\2\2\u0329\u032b\3\2\2\2\u032a"+
		"\u031e\3\2\2\2\u032a\u031f\3\2\2\2\u032a\u0322\3\2\2\2\u032a\u0325\3\2"+
		"\2\2\u032b\177\3\2\2\2\u032c\u032d\5\64\33\2\u032d\u032e\5R*\2\u032e\u0336"+
		"\3\2\2\2\u032f\u0330\5p9\2\u0330\u0331\5\64\33\2\u0331\u0336\3\2\2\2\u0332"+
		"\u0333\5r:\2\u0333\u0334\5\u0080A\2\u0334\u0336\3\2\2\2\u0335\u032c\3"+
		"\2\2\2\u0335\u032f\3\2\2\2\u0335\u0332\3\2\2\2\u0336\u0081\3\2\2\2\u0337"+
		"\u0338\7\3\2\2\u0338\u033a\7,\2\2\u0339\u033b\5\2\2\2\u033a\u0339\3\2"+
		"\2\2\u033a\u033b\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u033d\5x=\2\u033d\u033e"+
		"\7\4\2\2\u033e\u0358\3\2\2\2\u033f\u0340\7\3\2\2\u0340\u0342\7-\2\2\u0341"+
		"\u0343\5\2\2\2\u0342\u0341\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0344\3\2"+
		"\2\2\u0344\u0345\5\64\33\2\u0345\u0346\7\4\2\2\u0346\u0358\3\2\2\2\u0347"+
		"\u0348\7\3\2\2\u0348\u034a\7J\2\2\u0349\u034b\5\2\2\2\u034a\u0349\3\2"+
		"\2\2\u034a\u034b\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d\5\62\32\2\u034d"+
		"\u034e\7\4\2\2\u034e\u0358\3\2\2\2\u034f\u0350\7\3\2\2\u0350\u0352\78"+
		"\2\2\u0351\u0353\5\2\2\2\u0352\u0351\3\2\2\2\u0352\u0353\3\2\2\2\u0353"+
		"\u0354\3\2\2\2\u0354\u0355\5\60\31\2\u0355\u0356\7\4\2\2\u0356\u0358\3"+
		"\2\2\2\u0357\u0337\3\2\2\2\u0357\u033f\3\2\2\2\u0357\u0347\3\2\2\2\u0357"+
		"\u034f\3\2\2\2\u0358\u0083\3\2\2\2\u0359\u035a\7\3\2\2\u035a\u035b\7,"+
		"\2\2\u035b\u035c\5\b\5\2\u035c\u035d\7\4\2\2\u035d\u036e\3\2\2\2\u035e"+
		"\u035f\7\3\2\2\u035f\u0360\7-\2\2\u0360\u0361\5\16\b\2\u0361\u0362\7\4"+
		"\2\2\u0362\u036e\3\2\2\2\u0363\u0364\7\3\2\2\u0364\u0365\7J\2\2\u0365"+
		"\u0366\5\n\6\2\u0366\u0367\7\4\2\2\u0367\u036e\3\2\2\2\u0368\u0369\7\3"+
		"\2\2\u0369\u036a\78\2\2\u036a\u036b\5\f\7\2\u036b\u036c\7\4\2\2\u036c"+
		"\u036e\3\2\2\2\u036d\u0359\3\2\2\2\u036d\u035e\3\2\2\2\u036d\u0363\3\2"+
		"\2\2\u036d\u0368\3\2\2\2\u036e\u0085\3\2\2\2\u036f\u0373\5\36\20\2\u0370"+
		"\u0372\5n8\2\u0371\u0370\3\2\2\2\u0372\u0375\3\2\2\2\u0373\u0371\3\2\2"+
		"\2\u0373\u0374\3\2\2\2\u0374\u037e\3\2\2\2\u0375\u0373\3\2\2\2\u0376\u037a"+
		"\7,\2\2\u0377\u0379\5\b\5\2\u0378\u0377\3\2\2\2\u0379\u037c\3\2\2\2\u037a"+
		"\u0378\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037e\3\2\2\2\u037c\u037a\3\2"+
		"\2\2\u037d\u036f\3\2\2\2\u037d\u0376\3\2\2\2\u037e\u0087\3\2\2\2\u037f"+
		"\u0381\5\u008aF\2\u0380\u037f\3\2\2\2\u0381\u0384\3\2\2\2\u0382\u0380"+
		"\3\2\2\2\u0382\u0383\3\2\2\2\u0383\u0385\3\2\2\2\u0384\u0382\3\2\2\2\u0385"+
		"\u038e\7\2\2\3\u0386\u0388\5V,\2\u0387\u0386\3\2\2\2\u0388\u038b\3\2\2"+
		"\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038c\3\2\2\2\u038b\u0389"+
		"\3\2\2\2\u038c\u038e\7\2\2\3\u038d\u0382\3\2\2\2\u038d\u0389\3\2\2\2\u038e"+
		"\u0089\3\2\2\2\u038f\u0395\5\u008cG\2\u0390\u0395\5\u0090I\2\u0391\u0395"+
		"\5\u008eH\2\u0392\u0395\5\u0094K\2\u0393\u0395\5\u009aN\2\u0394\u038f"+
		"\3\2\2\2\u0394\u0390\3\2\2\2\u0394\u0391\3\2\2\2\u0394\u0392\3\2\2\2\u0394"+
		"\u0393\3\2\2\2\u0395\u008b\3\2\2\2\u0396\u0397\7\3\2\2\u0397\u0399\7>"+
		"\2\2\u0398\u039a\5\2\2\2\u0399\u0398\3\2\2\2\u0399\u039a\3\2\2\2\u039a"+
		"\u039e\3\2\2\2\u039b\u039d\5V,\2\u039c\u039b\3\2\2\2\u039d\u03a0\3\2\2"+
		"\2\u039e\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u03a1\3\2\2\2\u03a0\u039e"+
		"\3\2\2\2\u03a1\u03b5\7\4\2\2\u03a2\u03a3\7\3\2\2\u03a3\u03a5\7>\2\2\u03a4"+
		"\u03a6\5\2\2\2\u03a5\u03a4\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a7\3\2"+
		"\2\2\u03a7\u03a8\7[\2\2\u03a8\u03a9\5\32\16\2\u03a9\u03aa\7\4\2\2\u03aa"+
		"\u03b5\3\2\2\2\u03ab\u03ac\7\3\2\2\u03ac\u03ae\7>\2\2\u03ad\u03af\5\2"+
		"\2\2\u03ae\u03ad\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0"+
		"\u03b1\7b\2\2\u03b1\u03b2\5\32\16\2\u03b2\u03b3\7\4\2\2\u03b3\u03b5\3"+
		"\2\2\2\u03b4\u0396\3\2\2\2\u03b4\u03a2\3\2\2\2\u03b4\u03ab\3\2\2\2\u03b5"+
		"\u008d\3\2\2\2\u03b6\u03b7\7\3\2\2\u03b7\u03b9\7^\2\2\u03b8\u03ba\5\2"+
		"\2\2\u03b9\u03b8\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb"+
		"\u03bf\5\30\r\2\u03bc\u03be\5\u0092J\2\u03bd\u03bc\3\2\2\2\u03be\u03c1"+
		"\3\2\2\2\u03bf\u03bd\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c2\3\2\2\2\u03c1"+
		"\u03bf\3\2\2\2\u03c2\u03c3\7\4\2\2\u03c3\u03cd\3\2\2\2\u03c4\u03c5\7\3"+
		"\2\2\u03c5\u03c7\7\\\2\2\u03c6\u03c8\5\2\2\2\u03c7\u03c6\3\2\2\2\u03c7"+
		"\u03c8\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03ca\5\30\r\2\u03ca\u03cb\7"+
		"\4\2\2\u03cb\u03cd\3\2\2\2\u03cc\u03b6\3\2\2\2\u03cc\u03c4\3\2\2\2\u03cd"+
		"\u008f\3\2\2\2\u03ce\u03cf\7\3\2\2\u03cf\u03d0\7d\2\2\u03d0\u03d2\5\30"+
		"\r\2\u03d1\u03d3\5\2\2\2\u03d2\u03d1\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3"+
		"\u03d4\3\2\2\2\u03d4\u03d5\7\4\2\2\u03d5\u0091\3\2\2\2\u03d6\u03d7\7\3"+
		"\2\2\u03d7\u03d8\7\25\2\2\u03d8\u03d9\7\5\2\2\u03d9\u03f3\7\4\2\2\u03da"+
		"\u03db\7\3\2\2\u03db\u03dc\7\26\2\2\u03dc\u03dd\5\34\17\2\u03dd\u03de"+
		"\7\4\2\2\u03de\u03f3\3\2\2\2\u03df\u03e0\7\3\2\2\u03e0\u03e1\7\30\2\2"+
		"\u03e1\u03e3\5&\24\2\u03e2\u03e4\5\34\17\2\u03e3\u03e2\3\2\2\2\u03e4\u03e5"+
		"\3\2\2\2\u03e5\u03e3\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6\u03e7\3\2\2\2\u03e7"+
		"\u03e8\7\4\2\2\u03e8\u03f3\3\2\2\2\u03e9\u03ea\7\3\2\2\u03ea\u03eb\7E"+
		"\2\2\u03eb\u03ec\5 \21\2\u03ec\u03ed\7\4\2\2\u03ed\u03f3\3\2\2\2\u03ee"+
		"\u03ef\7\3\2\2\u03ef\u03f0\7c\2\2\u03f0\u03f1\7\5\2\2\u03f1\u03f3\7\4"+
		"\2\2\u03f2\u03d6\3\2\2\2\u03f2\u03da\3\2\2\2\u03f2\u03df\3\2\2\2\u03f2"+
		"\u03e9\3\2\2\2\u03f2\u03ee\3\2\2\2\u03f3\u0093\3\2\2\2\u03f4\u03f5\7\3"+
		"\2\2\u03f5\u03f6\7X\2\2\u03f6\u03fa\5\u008eH\2\u03f7\u03f9\5\u0096L\2"+
		"\u03f8\u03f7\3\2\2\2\u03f9\u03fc\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fa\u03fb"+
		"\3\2\2\2\u03fb\u03fd\3\2\2\2\u03fc\u03fa\3\2\2\2\u03fd\u03fe\7\4\2\2\u03fe"+
		"\u0424\3\2\2\2\u03ff\u0400\7\3\2\2\u0400\u0401\7Y\2\2\u0401\u0402\5\u008e"+
		"H\2\u0402\u0403\5\32\16\2\u0403\u0404\7\4\2\2\u0404\u0424\3\2\2\2\u0405"+
		"\u0406\7\3\2\2\u0406\u0407\7U\2\2\u0407\u0408\5\u008eH\2\u0408\u0409\5"+
		"\32\16\2\u0409\u040a\7\4\2\2\u040a\u0424\3\2\2\2\u040b\u040c\7\3\2\2\u040c"+
		"\u040d\7W\2\2\u040d\u040e\5\u008cG\2\u040e\u040f\5\32\16\2\u040f\u0410"+
		"\7\4\2\2\u0410\u0424\3\2\2\2\u0411\u0412\7\3\2\2\u0412\u0413\7V\2\2\u0413"+
		"\u0414\5\u008cG\2\u0414\u0415\5\32\16\2\u0415\u0416\7\4\2\2\u0416\u0424"+
		"\3\2\2\2\u0417\u0418\7\3\2\2\u0418\u0419\7Z\2\2\u0419\u041a\5\u008cG\2"+
		"\u041a\u041b\5\32\16\2\u041b\u041c\7\4\2\2\u041c\u0424\3\2\2\2\u041d\u041e"+
		"\7\3\2\2\u041e\u041f\7Y\2\2\u041f\u0420\5\u008cG\2\u0420\u0421\5\32\16"+
		"\2\u0421\u0422\7\4\2\2\u0422\u0424\3\2\2\2\u0423\u03f4\3\2\2\2\u0423\u03ff"+
		"\3\2\2\2\u0423\u0405\3\2\2\2\u0423\u040b\3\2\2\2\u0423\u0411\3\2\2\2\u0423"+
		"\u0417\3\2\2\2\u0423\u041d\3\2\2\2\u0424\u0095\3\2\2\2\u0425\u0441\5\u0092"+
		"J\2\u0426\u0427\7\3\2\2\u0427\u0428\7\25\2\2\u0428\u0429\5\u0098M\2\u0429"+
		"\u042a\7\4\2\2\u042a\u0441\3\2\2\2\u042b\u042c\7\3\2\2\u042c\u042d\7\26"+
		"\2\2\u042d\u042e\5\u0098M\2\u042e\u042f\7\4\2\2\u042f\u0441\3\2\2\2\u0430"+
		"\u0431\7\3\2\2\u0431\u0432\7\30\2\2\u0432\u0434\5&\24\2\u0433\u0435\5"+
		"\u0098M\2\u0434\u0433\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u0434\3\2\2\2"+
		"\u0436\u0437\3\2\2\2\u0437\u0438\3\2\2\2\u0438\u0439\7\4\2\2\u0439\u0441"+
		"\3\2\2\2\u043a\u043b\7\3\2\2\u043b\u043c\7c\2\2\u043c\u0441\7\4\2\2\u043d"+
		"\u043e\7\3\2\2\u043e\u043f\7C\2\2\u043f\u0441\7\4\2\2\u0440\u0425\3\2"+
		"\2\2\u0440\u0426\3\2\2\2\u0440\u042b\3\2\2\2\u0440\u0430\3\2\2\2\u0440"+
		"\u043a\3\2\2\2\u0440\u043d\3\2\2\2\u0441\u0097\3\2\2\2\u0442\u0446\5\34"+
		"\17\2\u0443\u0446\7`\2\2\u0444\u0446\7_\2\2\u0445\u0442\3\2\2\2\u0445"+
		"\u0443\3\2\2\2\u0445\u0444\3\2\2\2\u0446\u0099\3\2\2\2\u0447\u0448\7\3"+
		"\2\2\u0448\u044a\7e\2\2\u0449\u044b\5\2\2\2\u044a\u0449\3\2\2\2\u044a"+
		"\u044b\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u044d\5\u0088E\2\u044d\u044e"+
		"\7\4\2\2\u044e\u0461\3\2\2\2\u044f\u0450\7\3\2\2\u0450\u0452\7]\2\2\u0451"+
		"\u0453\5\2\2\2\u0452\u0451\3\2\2\2\u0452\u0453\3\2\2\2\u0453\u0454\3\2"+
		"\2\2\u0454\u0455\5\u0088E\2\u0455\u0456\7\4\2\2\u0456\u0461\3\2\2\2\u0457"+
		"\u0458\7\3\2\2\u0458\u045a\7a\2\2\u0459\u045b\5\2\2\2\u045a\u0459\3\2"+
		"\2\2\u045a\u045b\3\2\2\2\u045b\u045d\3\2\2\2\u045c\u045e\5\u0088E\2\u045d"+
		"\u045c\3\2\2\2\u045d\u045e\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0461\7\4"+
		"\2\2\u0460\u0447\3\2\2\2\u0460\u044f\3\2\2\2\u0460\u0457\3\2\2\2\u0461"+
		"\u009b\3\2\2\2v\u00b7\u00cb\u00d1\u00db\u00e5\u00eb\u00f4\u00fa\u0100"+
		"\u0104\u010e\u0111\u0114\u0117\u011a\u011d\u0125\u012d\u0135\u013d\u0142"+
		"\u0144\u014e\u015a\u0161\u0164\u016b\u0172\u0175\u0181\u0185\u0189\u018d"+
		"\u0191\u0195\u019b\u019f\u01a4\u01be\u01c5\u01cc\u01d2\u01d7\u0200\u0204"+
		"\u0209\u020f\u0214\u021c\u0220\u022c\u0231\u0239\u0241\u0249\u0251\u026b"+
		"\u0273\u0276\u027f\u0285\u028d\u0293\u0298\u02a0\u02a3\u02a9\u02b1\u02b9"+
		"\u02d7\u02dd\u02e3\u02e9\u02ec\u02f2\u02fd\u030c\u0317\u031c\u032a\u0335"+
		"\u033a\u0342\u034a\u0352\u0357\u036d\u0373\u037a\u037d\u0382\u0389\u038d"+
		"\u0394\u0399\u039e\u03a5\u03ae\u03b4\u03b9\u03bf\u03c7\u03cc\u03d2\u03e5"+
		"\u03f2\u03fa\u0423\u0436\u0440\u0445\u044a\u0452\u045a\u045d\u0460";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}