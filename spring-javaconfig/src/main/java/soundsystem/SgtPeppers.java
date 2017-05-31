package soundsystem;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/19 16:16
 */
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt . Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing  "+ title+" by "+artist);
    }
}
