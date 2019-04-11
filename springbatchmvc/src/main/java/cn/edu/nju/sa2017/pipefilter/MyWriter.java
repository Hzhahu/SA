package cn.edu.nju.sa2017.pipefilter;

import org.springframework.batch.item.ItemWriter;
import java.io.*;
import java.util.List;

public class MyWriter implements ItemWriter<Report>{
    private String resource;
    @Override
    public void write(List<? extends Report> list) throws Exception {
        File file=new File("xml/outputs/output.txt");
        FileWriter out=new FileWriter(file);
        try{
            for(int i=0;i<list.size();i++){
                Report context=list.get(i);
                out.write(context.toFile()+"\r\n");
                out.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        out.close();
    }

    public void setResource(String resource) {
        this.resource=resource;
    }
}
