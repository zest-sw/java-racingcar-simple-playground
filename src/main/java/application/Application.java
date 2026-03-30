package application;

import domain.Contest;
import utils.applicationIOManager.ApplicationIOManager;
import utils.applicationIOManager.UserInput;

public class Application {

    public void run() {
        ApplicationIOManager IOmanager = new ApplicationIOManager();

        UserInput userInput = IOmanager.getUserInput();

        Contest contest = new Contest(userInput);
        contest.startContest();


        String[] winners = contest.getWinners();
        IOmanager.printResult(winners);
    }
}
