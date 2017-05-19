package soundsystem;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/19 16:39
 */
public class Qilixiang implements CompactDisc {
    private String artist = "zhoujielun";
    private String title="qi li xiang";
    @Override
    public void play() {
        System.out.println("Playing  "+ title+" by "+artist);
    }
}
