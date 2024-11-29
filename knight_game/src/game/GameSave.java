package game;

import java.io.FileOutputStream; // 파일에 데이터 저장하는 스트림
import java.io.IOException; // 저장시 발생하는 예외 처리
import java.io.ObjectOutputStream; // 자바 객체를 파일에 저장할 수 있도록 하는 스트림

public class GameSave {
	// 인자로 캐릭터 객체와, 저장할 파일 이름을 받음
	public static void saveCharacter(Character character, String fileName) {
		try (
				// 인자로 받은 파일 이름으로 파일 생성
				FileOutputStream fos = new FileOutputStream(fileName);
				// 객체를 직렬화 하여 객체를 파일에 저장 능능
				// 직렬화란 객체를 파일에 전송하기 적합한 형태로 바꾸어 저장 또는 복원 가능
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			// 캐릭터 객체를 파일에 작성 캐릭터 클래스가 Serializable 인터페이스를 구현해야 함
			oos.writeObject(character);
			System.out.println("캐릭터 정보가 저장되었습니다: " + character);
			// 오류 발생시 해당 코드 실행
		} catch (IOException e) {
			System.out.println("저장 중 오류가 발생했습니다: " + e.getMessage());
		}
	}
}
