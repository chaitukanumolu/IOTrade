package stream.kite;

import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.SessionExpiryHook;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.Tick;
import com.zerodhatech.models.User;
import com.zerodhatech.ticker.KiteTicker;

import java.io.IOException;

public class KiteConnector {
    private static KiteConnect kiteSdk = null;

    public static KiteConnect getKiteConnect(){
        if(kiteSdk==null){
            kiteSdk = new KiteConnect(KiteCreds.API_KEY);
            kiteSdk.setUserId(KiteCreds.USER_ID);

            User user = null;
            try {
                user = kiteSdk.generateSession(KiteCreds.REQUEST_TOKEN, KiteCreds.API_SECRET);
            } catch (KiteException e) {
                System.out.println("Kite exception = "+e.getMessage());
                System.exit(-1);
            } catch (IOException e) {
                System.out.println("IO Exception = "+e.getMessage());
                System.exit(-1);
            }

            kiteSdk.setAccessToken(user.accessToken);
            kiteSdk.setPublicToken(user.publicToken);

            kiteSdk.setSessionExpiryHook(new SessionExpiryHook() {
                @Override
                public void sessionExpired() {
                    System.out.println("session expired");
                }
            });
        }

        Tick tick;
        //tick.getOi()
        tick.get

       KiteTicker tickerProvider;// = new KiteTicker()
        tickerProvider.subscribe();
        //tickerProvider.
        return kiteSdk;
    }

}
