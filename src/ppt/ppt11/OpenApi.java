package ppt.ppt11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 영화진흥위원회 의 오픈API 사용 URL 데이터를 가져와서 jSON 객체로 만들는 클래스
 * @author 402_S
 *
 */
public class OpenApi {

	public static void main(String[] args) throws Exception {
		// 초기 일별 영화 박스오피스 요청 URL을 입력
		String requestURL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220101";
		serviceAPI(requestURL);//RestAPI 서버에서 제이슨데이터를 가져오는 메서드. 

	}
	//JSONArray 배열객체 클래스는 기본 라이브러리가 아니기 때문에, 외부 저장소에서 가져와서 등록으 시켜야 한다.
	//메이븐 Maven 저장소에서 org.json.jar 실행파일을 가져옵니다.
	public static JSONArray serviceAPI(String requestURL) throws Exception {
		// URL에서 json데이터를 가져오는 구문(아래)
		BufferedReader bReader = null;
		URL url = new URL(requestURL);//스트링 url을 자바용 URL로 변경한다.
		HttpURLConnection hConnection = (HttpURLConnection) url.openConnection();//형변환 2번째
		hConnection.setRequestMethod("GET");//요청주소가 오픈된 주소 <-> POST 
		System.out.println("응답코드 확인: " + hConnection.getResponseCode());//정상 200
		//-----------------------------------------------
		//json 데이터를 읽어 들이기 버퍼드 리더로 문자열 읽어들이기
		//스트림 클래스라는 데이터 이동 공간을 사용해서 글자를 읽어 들인다.
		bReader = new BufferedReader(new InputStreamReader(hConnection.getInputStream()));
		//버퍼에 들어 있는 데이터는 일렬로 되어 있는 데이터 -> 토큰데이터로 만들기 (시리얼라이즈)
		StringBuilder sBuilder = new StringBuilder();//토큰데이터 만드는 객체 생성
		String line;//토큰 데이터가 들어가 변수=공간
		//반복문으로 한줄 데이터를 여러줄로 만든다.=토큰=시리얼라이즈
		while((line = bReader.readLine()) !=null ) {
			sBuilder.append(line);//1줄로 구성된 데이터 구조를 만든다. 최종값은 sBuilder 객체 담긴다.
		}
		bReader.close();//null 객체를 지운다.
		hConnection.disconnect();//객체를 지운다.
		JSONObject jObject = new JSONObject(sBuilder.toString());//빌더의 토큰값을 jSon데이터형태로 변경
		//System.out.println(jObject);
		JSONObject boxOfficeResult = (JSONObject) jObject.get("boxOfficeResult");
		JSONArray dailyBoxOfficeList = (JSONArray) boxOfficeResult.get("dailyBoxOfficeList");
		//파싱종료
		System.out.println(dailyBoxOfficeList);
		return dailyBoxOfficeList;		
	}

}