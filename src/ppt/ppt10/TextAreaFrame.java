package ppt.ppt10;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import basic.Basic12_OpenApi;

class DailyBoxOffice { //일일 영화 박스오피스 데이터 클래스
	private String rank;//순위
	private String audiCnt;//일별관객수
	private String movieNm;//영화제목
	
	public DailyBoxOffice(String rank, String audiCnt, String movieNm) {
		this.rank = rank;
		this.audiCnt = audiCnt;
		this.movieNm = movieNm;
	}

	@Override
	public String toString() {
		return "[rank=" + rank + ", audiCnt=" + audiCnt + ", movieNm=" + movieNm + "]";
	}
	
}

public class TextAreaFrame extends JFrame implements ActionListener {
       protected JTextField textField;
       protected JTextArea textArea;
 
       public TextAreaFrame() {
             setTitle("Text Area Test");
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             textField = new JTextField("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220101", 100);
             textField.addActionListener(this);
 
             textArea = new JTextArea(10, 100);
             textArea.setEditable(false);
             JScrollPane scrollPane = new JScrollPane(textArea);

             add(textField, BorderLayout.NORTH);
             //add(textArea, BorderLayout.CENTER);
             add(scrollPane, BorderLayout.CENTER);
             //setSize(300, 200);
             pack();//위 프레임 사이즈 대신에 내용만큼 자동으로 크기를 조정한다.
             setVisible(true);
       }
 

       public void actionPerformed(ActionEvent evt) {
             String text = textField.getText();
             Basic12_OpenApi api = new Basic12_OpenApi();
             try {
            	 JSONArray jsonArray = api.serviceApi(text);
            	 //System.out.println(jsonArray);
            	 for(Object jsonOne : jsonArray) {
            		 JSONObject jsonObject = (JSONObject) jsonOne;
            		 System.out.println(jsonObject.get("rank"));
            		 DailyBoxOffice dBoxOffice = new DailyBoxOffice(jsonObject.get("rank").toString(),jsonObject.get("audiCnt").toString(),jsonObject.get("movieNm").toString());
            		 textArea.append(dBoxOffice.toString() + "\n");
            	 }
            	 textField.selectAll();
                 textArea.setCaretPosition(textArea.getDocument().getLength());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }

       public static void main(String[] args) {
             new TextAreaFrame();
       }
}