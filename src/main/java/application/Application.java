package application;

import domain.Contest;
import utils.applicationIOMangager.ApplicationIOManager;
import utils.applicationIOMangager.UserInput;

public class Application {

    public static void main(String[] args) {
        ApplicationIOManager IOmanager = new ApplicationIOManager();

        UserInput userInput = IOmanager.getUserInput();
        
        Contest contest = new Contest(userInput);
        contest.startContest();


        String[] winners = contest.getWinners();
        IOmanager.printResult(winners);
    }
}
