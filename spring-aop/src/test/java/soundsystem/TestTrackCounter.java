package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/27 15:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TestTrackCounter {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testTrackCounter(){
        cd.playTrack(1);
        cd.playTrack(3);
        cd.playTrack(1);
        cd.playTrack(1);
        cd.playTrack(4);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(1);

        assertEquals(4,trackCounter.getPlayCount(1));
        assertEquals(2,trackCounter.getPlayCount(2));
        assertEquals(1,trackCounter.getPlayCount(3));
        assertEquals(1,trackCounter.getPlayCount(4));
    }
}
