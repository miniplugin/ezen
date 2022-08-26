package ppt.ppt11;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

public class OpenApiTest extends JFrame {

	static public class TextAreaFrame extends JFrame implements ActionListener {
		//멤버변수
		JTextField jField;
		JTextArea jArea;
		JButton jButton;//원격 데이터서버 자료를 가져오는 이벤트용 버튼
		//화면생성		
		@Override//자동실행 = 콜백(백그라운드호출)
		public void actionPerformed(ActionEvent e) {
			// jField 입력란에 엔터를 눌렀을때 액션처리(아래)
			String line = jField.getText();
			//jsonObject 를 가져오는 코드: 클래스를 분리해서 필요한 메서드만 호출해서 사용예정
			OpenApi oApi = new OpenApi();
			try {
				JSONArray jArray = oApi.serviceAPI(line);//파싱된 Json 데이터 받기
				for(Object object:jArray) {//배열객체에서 1개씩 객체를 가져온다. 
					JSONObject jObject = (JSONObject) object;
					jArea.append(jObject.get("rank") + "," 
					+ jObject.get("audiCnt") 
					+ jObject.get("movieNm")
					+"\n");//데이터가 1줄 입력후 엔터\n 누적된다.
				}				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			//jArea.setText(line);//기존 데이터를 지우고 새로운 데이터를 입력
			
			
		}

		public TextAreaFrame() throws HeadlessException {//화면초기화:제일먼저 실행
			// 화면을 생성하는 클래스 구현
			setDefaultCloseOperation(EXIT_ON_CLOSE);//화면을 x 버튼을 눌렀을때 프로그램 터미네이트 실행하라.
			setTitle("여러줄 문자열 입력 이벤트");//프레임설정
			//콤포넌트 생성
			jField = new JTextField("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220101", 100);//키보드로 한줄 입력하는 란
			jField.addActionListener(this);//기본 이벤트는 엔터(VK_ENTER)이고, 클릭이벤트와 같다.
			jButton = new JButton("가져오기");
			jButton.addActionListener(this);//이벤트 액션 추가 클릭 이벤트
			jArea = new JTextArea(10, 100);//10행 30열의 출력 란
			jArea.setEditable(false);
			//스크롤 페인 스크롤이 있는 컨트이너를 만든다(아래)
			JScrollPane jPane = new JScrollPane(jArea);//멀티라인 입력란을 스크롤로 감싸주기
			//프레임에 컴포넌트 출력
			add(jField, BorderLayout.NORTH);
			add(jButton, BorderLayout.CENTER);
			//add(jArea, BorderLayout.SOUTH);
			add(jPane, BorderLayout.SOUTH);
			pack();//자동크기조정(내부값에 따라서 자동으로 윈도우 프레임크기가 설정)
			setVisible(true);
		}

	}

	public static void main(String[] args) {
		// 화면 객체생성
		new TextAreaFrame();
	}

}