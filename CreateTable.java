import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class CreateTable {

	public static void main(String[] args) throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		// TODO Auto-generated method stub
		Configuration conf=HBaseConfiguration.create();
		HBaseAdmin admin=new HBaseAdmin(conf);
		HTableDescriptor table=new HTableDescriptor(TableName.valueOf("company"));
		table.addFamily(new HColumnDescriptor("details"));
		
		admin.createTable(table);
		System.out.println("Table Created");

	}

}
