package br.com.stomach.recipe.viewsmodels;

import br.com.stomach.recipe.models.GolangModel;

public class BotViewModel {

    GolangViewModel _golangViewModel;

    public BotViewModel() {
    }

    public String getMessage(String inital)
    {
        GolangModel golang = null;
        try {
            _golangViewModel = new GolangViewModel();
            golang = _golangViewModel.getMessage(inital);
        } catch (Exception e) {
            e.toString();
        }
        return golang.getMessage();
    }
    /*
    private GolangModel golangModel;
    public final GolangModel getMessage() { return golangModel;}
    public BotViewModel() {
        HandlerThread handlerThread = new HandlerThread("Golang");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                HttpGolang httpMessage = new HttpGolang();
                String response = httpMessage.getMessage();
                GolangParser golang = new GolangParser();
                golangModel = golang.parse(response);
            }
        };
        handler.post(myRunnable);
    }
    */
}
