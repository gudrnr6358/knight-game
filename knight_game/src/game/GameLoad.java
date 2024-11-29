package game;

import java.io.FileInputStream; // 파일을 읽어 오는 스트림
import java.io.IOException;
import java.io.ObjectInputStream; // 객체를 읽는 스트림

public class GameLoad {
	// 인자로 불러올 파일명을 받음
	public static Character loadCharacter(String fileName) {
		// 캐릭터 객체를 받기 위함
		Character character = null;

		// 주어진 파일 이름으로 바이트를 읽어 객체 단위로 데이터 읽어옴
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis)) {
			// 캐릭터 변수에 객체를 읽어와 캐릭터타입으로 캐스팅 하여 캐릭터 객체 생성
			character = (Character) ois.readObject();
			System.out.println("캐릭터 정보가 불러와졌습니다: " + character);
			// 오류 발생 시
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("불러오기 중 오류가 발생했습니다: " + e.getMessage());
		}
		// 생성된 캐릭터 객체 반환
		return character;
	}
}
