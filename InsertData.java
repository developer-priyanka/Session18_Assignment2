import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class InsertData {
	Configuration conf;
	public InsertData() throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
		conf=HBaseConfiguration.create();	//instantiating configuration class
	}
	public void insert() throws IOException{
		HTable table=new HTable(conf,"company");//Instantiating Htable class
		Put p=new Put(Bytes.toBytes("row2"));//instantiating put class .accepts a row name
		p.add(Bytes.toBytes("details"),Bytes.toBytes("name"),Bytes.toBytes("Accenture"));
		p.add(Bytes.toBytes("details"),Bytes.toBytes("city"),Bytes.toBytes("Hyderabad"));
		p.add(Bytes.toBytes("details"),Bytes.toBytes("address"),Bytes.toBytes("Gachhibowli"));
		p.add(Bytes.toBytes("details"),Bytes.toBytes("regNo"),Bytes.toBytes("110234"));
		table.put(p);
		System.out.println("Data inserted");
		table.close();
	}
	
	public static void main(String[] args) throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		
		InsertData insertdata=new InsertData();
		insertdata.insert();	
		

	}

}
