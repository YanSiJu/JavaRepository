package cn.csu.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongodbJdbc {
	public static void main(String args[]) {
		MongoClient mongoClient = null;
		try {
			// ���ӵ� mongodb ����
			mongoClient = new MongoClient("localhost", 27017);

			// ���ӵ����ݿ�
			MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
			System.out.println("Connect to database successfully");
			System.out.println(mongoClient);
			System.out.println(mongoDatabase);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			if (mongoClient != null) {
				mongoClient.close();
			}
		}
	}
}
