import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// переделать из статического класса в обычный, и добавить разновидность команд,
// которые будут использовать для проверки в GameLoop

// я короче придумал переделать его из статического в обычный класс,
// и короче, я внутри него сделаю разные типы команд,
// которые будут проверяться в GameLoop и там решаться что дальше делать с командой,
// системные будут влиять на isRunning переменную для цикла,
// специальные команды которые будут для всех локаций использоваться
// это "Взять", "Осмотреть", "Открыть", это команды которые нужно самому писать ,
// а по пунктам выбирается направление куда идти.
// То есть если в локации есть что взять, то при написании Взять, предмет возьмётся и положиться в инвентарь
public class SystemCommand {
    private static final List<String> commandList = Arrays.asList( "exit");

    private static boolean gameExit() {
        return false;
    }

    public static boolean execute(String prompt) {

        if (prompt.equalsIgnoreCase("exit")) {
            return gameExit();
        } else {
            return true;
        }
    }

    public static boolean isCommand(String prompt) {
        return commandList.contains(prompt);
    }
}
