import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class profile2Object implements WritableComparable {

    private int count;
    private int id;

    public profile2Object(){
        id = 0;
        count = 0;
    }

    public profile2Object(int count, int id) {
        this.count = count;
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof profile2Object) {
            profile2Object compare = (profile2Object) o;
            if(this.id == compare.id && this.count == compare.count){
                return 0;
            }
            else if(this.id == compare.id){
                return -1*(this.count - compare.count);
            }
            else{
                return -1 * ((this.id - compare.id) + (this.count - compare.count));
            }
        }
        else{
            return -1;
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(count);
        dataOutput.writeInt(id);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        count = dataInput.readInt();
        id = dataInput.readInt();

    }

    @Override
    public String toString(){
        return ""+count;
    }

}
