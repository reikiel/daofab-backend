package com.example;

import com.example.model.Child;
import com.example.model.Parent;
import com.example.repository.ChildRepository;
import com.example.repository.ParentRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DaofabBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DaofabBackendApplication.class, args);
	}

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private ChildRepository childRepository;

	@Override
	public void run(String... args) throws Exception {
		try {
			JSONParser parser = new JSONParser();
			String filePath = new File("").getAbsolutePath();

			// parse and save parent data to parent repo
			Object parentObj = parser.parse(new FileReader(filePath+"/src/main/java/com/example/Parent.json"));
			JSONObject jsonParentObject = (JSONObject) parentObj;
			JSONArray parentData = (JSONArray) jsonParentObject.get("data");

			for (int i=0;i<parentData.size();i++) {
				JSONObject parent = (JSONObject) parentData.get(i);
				String sender = parent.get("sender").toString();
				String receiver = parent.get("receiver").toString();
				int totalAmount = Integer.valueOf(parent.get("totalAmount").toString());
//				System.out.println(sender + " " + receiver + " " + totalAmount);
				this.parentRepository.save(new Parent(sender, receiver, totalAmount));
			}

			// parse and save child data to child repo
			Object childObj = parser.parse(new FileReader(filePath+"/src/main/java/com/example/Child.json"));
			JSONObject jsonChildObject = (JSONObject) childObj;
			JSONArray childData = (JSONArray) jsonChildObject.get("data");

			for (int i=0;i<childData.size();i++) {
				JSONObject child = (JSONObject) childData.get(i);
				int paidAmount = Integer.valueOf(child.get("paidAmount").toString());
				long parentId = (long) child.get("parentId");

				// get the parent
				Parent parent = this.parentRepository.findById(parentId);

				// get parent details
				String sender = parent.getSender();
				String receiver = parent.getReceiver();
				int totalAmount = parent.getTotalAmount();


				this.childRepository.save(new Child(parentId, sender, receiver, totalAmount, paidAmount));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
