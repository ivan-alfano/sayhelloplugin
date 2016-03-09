package com.CordovaPlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class SayHelloPlugin extends CordovaPlugin {
	
	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) 
			throws JSONException {
		if (action.equals("sayHello")){
			try {
				final String responseText = "Hello " + args.getString(0);
				cordova.getThreadPool().execute(new Runnable() {
					public void run() {	        	
						callbackContext.success(responseText); // Thread-safe.
					}
				});
			} catch (JSONException e){
				callbackContext.error("Failed to parse parameters");
			}
			return true;
	    }
		return false;
	}
}
