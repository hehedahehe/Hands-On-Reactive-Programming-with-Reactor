package learn.observerpattern;

import org.junit.Test;

public class TestMain {

    @Test
    public void test(){
        /*
         * create subject
         */
        NewsChannel newsChannelObj = new NewsChannel();

        /*
         * create observers
         */
        Observer viewerObj1 = new Viewers("Viewer 1");
        Observer viewerObj2 = new Viewers("Viewer 2");
        Observer viewerObj3 = new Viewers("Viewer 3");

        /*
         * register observers to the subject
         */
        newsChannelObj.register(viewerObj1);
        newsChannelObj.register(viewerObj2);
        newsChannelObj.register(viewerObj3);

        /*
         * attach observer to subject
         */
        viewerObj1.setSubject(newsChannelObj);
        viewerObj2.setSubject(newsChannelObj);
        viewerObj3.setSubject(newsChannelObj);

        /*
         * check if any update is available
         */
        viewerObj1.update();

        /*
         * now send message to subject
         */
        newsChannelObj.postNewsHeadLine("Breaking News 1");
    }
}
