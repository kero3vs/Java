package javascript;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Sample {

	public static void main(String[] args) throws Exception {


		if(args.length == 0){
			System.out.println("引数が足りません。\n[0]:JavaScriptファイル名\n[1]数値\n[2]数値");
			return;
		}

		BufferedReader br = new BufferedReader( new FileReader( new File("./js/" + args[0])) );

		ScriptEngineManager manager = new ScriptEngineManager();

		ScriptEngine engine = manager.getEngineByName("javascript");

		engine.eval(br.readLine());

		Invocable invocable = (Invocable) engine;

		invocable.invokeFunction("execute", Integer.parseInt(args[1]),Integer.parseInt(args[2]));
	}
}
