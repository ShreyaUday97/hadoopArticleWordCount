import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class reverseOrderPartitioner extends Partitioner<Text, MyComparator> {
    @Override
    public int getPartition(Text key, MyComparator value, int numReducers) {
        if (numReducers == 6) {
            if (key.getLength() > 0) {
                String pkey = key.toString().toLowerCase();
                Integer partitionKey = Integer.parseInt(pkey);
                if (partitionKey >= 200)
                    return 0;
                else if (partitionKey >= 70 && partitionKey <= 199)
                    return 1;
                else if (partitionKey >= 30 && partitionKey <= 69)
                    return 2;
                else if (partitionKey >= 5 && partitionKey <= 29)
                    return 3;
                else if (partitionKey >= 2 && partitionKey <= 4)
                    return 4;
                else
                    return 5;
            }
        }
        return 0;
    }
}

