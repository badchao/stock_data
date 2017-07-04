package com.github.stock_data.jython;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;
import org.python.jsr223.PyScriptEngineFactory;
import org.python.jsr223.ScriptEngineTest;

import com.github.rapid.common.util.ScriptEngineUtil;

public class JythonTest {

	@Test
	public void test() throws Exception {
		System.setProperty("python.home", "D:\\dev\\Python27");
		
		ScriptEngineManager manager = new ScriptEngineManager();
		PyScriptEngineFactory engineFactory = new PyScriptEngineFactory();
		manager.registerEngineName("python", engineFactory);
//		new ScriptEngineTest().testEvalString();
		
		ScriptEngine engine = manager.getEngineByName("python");
		System.out.println("engine:"+engine);
		engine = engineFactory.getScriptEngine();
		engine.eval("print('hello world from jython')");
		
		ScriptEngineUtil.eval("python", "import tushare as ts;\n print(ts.get_operation_data(2014,3));");
//		ScriptEngineUtil.eval("jython", "print('hello world from jython')");
	}
	
}
