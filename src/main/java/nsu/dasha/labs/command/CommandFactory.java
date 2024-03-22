package nsu.dasha.labs.command;

import nsu.dasha.labs.exception.NotEnoughArgsException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class CommandFactory {
    HashMap<String, String> commandList = new HashMap<>();
    private void commandLoad() throws IOException {
        InputStream inputStream = CommandFactory.class.getClassLoader().getResourceAsStream("config.txt");
        assert inputStream != null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String configLine;

            while ((configLine = reader.readLine()) != null) {
                String[] configLineParams = configLine.split("\\s+"); //следим за каждым пробельным символом
                commandList.put(configLineParams[0], configLineParams[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Command get(String name) throws NotEnoughArgsException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        commandLoad();
        Command object = (Command) Class.forName(commandList.get(name)).getDeclaredConstructor().newInstance();
        return object;
    }
}