import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GameLoop {
    private boolean isRunning = true;
    GameState gameState = GameState.EXPLORING;
    GameInput INPUT = new GameInput();
    GameManager gameManager = new GameManager();


   public void loop(Player player, World world) {

       while (isRunning) {
           Location playerLocation = player.getCurrentLocation();
           System.out.println(player.getLocName());
           System.out.println("Описание локации: " + player.getLocDescription());
           Map<Integer, Location> currentChoices = gameManager.handler(playerLocation);

           if (player.getHp() <= 0) {
                isRunning = false;
           }

           String prompt = INPUT.getInput();

           
           if (gameState != GameState.IN_INVENTORY) {
               if (SystemCommand.isCommand(prompt)) {
                   isRunning = SystemCommand.execute(prompt);


               } else {
                   try {
                       int choiceNumber = Integer.parseInt(prompt);
                       gameManager.choicesHandler(choiceNumber, player, currentChoices);
                   } catch (NumberFormatException e) {
                       System.out.println("Некорректный ввод: Введите номер или команду.\n");
                   }
               }
           }

       }

       INPUT.closeScanner();
       System.out.println("\n Завершение игры \n");
   }
}
