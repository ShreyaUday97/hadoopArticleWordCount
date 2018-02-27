
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class profile2Mapper extends Mapper<LongWritable, Text, MyComparator, Text>{
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        if(!value.toString().isEmpty()) {

            int documentId = 0;
            String documentTitle = "";

            StringTokenizer title = new StringTokenizer(value.toString().split("<====>")[0]);

            while(title.hasMoreTokens()){
                documentTitle += title.nextToken();
            }
            StringTokenizer id = new StringTokenizer(value.toString().split("<====>")[1]);
            while(id.hasMoreTokens()){
                String docID = id.nextToken();
                documentId = Integer.parseInt(docID);
            }
            StringTokenizer data = new StringTokenizer(value.toString().split("<====>")[2]);
            while (data.hasMoreTokens()) {
                String out = data.nextToken().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
                context.write(new MyComparator(documentId, documentTitle, out), new Text("one"));
            }
        }
    }
}