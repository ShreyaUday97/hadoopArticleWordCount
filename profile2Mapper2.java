
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class profile2Mapper2 extends Mapper<LongWritable, Text, profile2Object, MyComparator>{
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String [] words = value.toString().split("\\t");
        if (words.length > 1)
            context.write(new profile2Object(Integer.parseInt(words[2]),Integer.parseInt(words[0])),
                    new MyComparator(Integer.parseInt(words[0]), "",words[1]));
    }
}