import javax.imageio.IIOException;
import java.io.*;

public class Save {
    public static void save(GameCharacter player){
            try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("saves/Player.ser"))){

                oos.writeObject(player);


            } catch (IOException e) {
                System.out.println(e);;
            }
    }
    public static GameCharacter load(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saves/Player.ser"))){
            return (GameCharacter) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return null;
    }



}

