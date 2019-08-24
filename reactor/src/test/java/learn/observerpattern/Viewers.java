package learn.observerpattern;

public class Viewers implements Observer {

    private String viewerName;
    private Subject newsChannelObj;

    public Viewers(String viewerName){
        this.viewerName=viewerName;
    }

    @Override
    public void update() {
        String msg = (String) newsChannelObj.getUpdate(this);
        if(msg == null){
            System.out.println(viewerName+":: No New News Found.");
        }else
            System.out.println(viewerName+":: New News :"+msg);
    }

    @Override
    public void setSubject(Subject subjectObj) {
        this.newsChannelObj=subjectObj;
    }
}