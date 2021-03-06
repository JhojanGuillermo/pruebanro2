// The native Toast API
import android.annotation.TargetApi;
import android.os.Build;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.jnbis.api.Jnbis;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Base64;

// Cordova-required packages
@TargetApi(Build.VERSION_CODES.O)
public class pruebanro2 extends CordovaPlugin {
    String base64 = "";
    String base64Imagen = "";

            byte[] filedata = Base64.getDecoder().decode(base64);
            byte[] gifBytes = Jnbis.wsq()
                    .decode(filedata)
                    .toGif()
                    .asByteArray();


    @Override
  public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) {

      // Verify that the user sent a 'show' action
      if (!action.equals("show")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }
      try {
        JSONObject options = args.getJSONObject(0);
        base64 = options.getString("message");
        base64Imagen = new String (Base64.getEncoder().encode(gifBytes));
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }
      // Send a positive result to the callbackContext
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
  }
}