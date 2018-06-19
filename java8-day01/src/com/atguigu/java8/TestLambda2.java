package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/*
 * 涓�銆丩ambda 琛ㄨ揪寮忕殑鍩虹璇硶锛欽ava8涓紩鍏ヤ簡涓�涓柊鐨勬搷浣滅 "->" 璇ユ搷浣滅绉颁负绠ご鎿嶄綔绗︽垨 Lambda 鎿嶄綔绗�
 * 						    绠ご鎿嶄綔绗﹀皢 Lambda 琛ㄨ揪寮忔媶鍒嗘垚涓ら儴鍒嗭細
 * 
 * 宸︿晶锛歀ambda 琛ㄨ揪寮忕殑鍙傛暟鍒楄〃
 * 鍙充晶锛歀ambda 琛ㄨ揪寮忎腑鎵�闇�鎵ц鐨勫姛鑳斤紝 鍗� Lambda 浣�
 * 
 * 璇硶鏍煎紡涓�锛氭棤鍙傛暟锛屾棤杩斿洖鍊�
 * 		() -> System.out.println("Hello Lambda!");
 * 
 * 璇硶鏍煎紡浜岋細鏈変竴涓弬鏁帮紝骞朵笖鏃犺繑鍥炲��
 * 		(x) -> System.out.println(x)
 * 
 * 璇硶鏍煎紡涓夛細鑻ュ彧鏈変竴涓弬鏁帮紝灏忔嫭鍙峰彲浠ョ渷鐣ヤ笉鍐�
 * 		x -> System.out.println(x)
 * 
 * 璇硶鏍煎紡鍥涳細鏈変袱涓互涓婄殑鍙傛暟锛屾湁杩斿洖鍊硷紝骞朵笖 Lambda 浣撲腑鏈夊鏉¤鍙�
 *		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("鍑芥暟寮忔帴鍙�");
 *			return Integer.compare(x, y);
 *		};
 *
 * 璇硶鏍煎紡浜旓細鑻� Lambda 浣撲腑鍙湁涓�鏉¤鍙ワ紝 return 鍜� 澶ф嫭鍙烽兘鍙互鐪佺暐涓嶅啓
 * 		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * 
 * 璇硶鏍煎紡鍏細Lambda 琛ㄨ揪寮忕殑鍙傛暟鍒楄〃鐨勬暟鎹被鍨嬪彲浠ョ渷鐣ヤ笉鍐欙紝鍥犱负JVM缂栬瘧鍣ㄩ�氳繃涓婁笅鏂囨帹鏂嚭锛屾暟鎹被鍨嬶紝鍗斥�滅被鍨嬫帹鏂��
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 * 
 * 涓婅仈锛氬乏鍙抽亣涓�鎷彿鐪�
 * 涓嬭仈锛氬乏渚ф帹鏂被鍨嬬渷
 * 妯壒锛氳兘鐪佸垯鐪�
 * 
 * 浜屻�丩ambda 琛ㄨ揪寮忛渶瑕佲�滃嚱鏁板紡鎺ュ彛鈥濈殑鏀寔
 * 鍑芥暟寮忔帴鍙ｏ細鎺ュ彛涓彧鏈変竴涓娊璞℃柟娉曠殑鎺ュ彛锛岀О涓哄嚱鏁板紡鎺ュ彛銆� 鍙互浣跨敤娉ㄨВ @FunctionalInterface 淇グ
 * 			 鍙互妫�鏌ユ槸鍚︽槸鍑芥暟寮忔帴鍙�
 */
public class TestLambda2 {
	
	@Test
	public void test1(){
		int num = 0;//jdk 1.7 鍓嶏紝蹇呴』鏄� final
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!" + num);
			}
		};
		
		r.run();
		
		System.out.println("-------------------------------");
		
		Runnable r1 = () -> System.out.println("Hello Lambda!");
		r1.run();
	}
	
	@Test
	public void test2(){
		Consumer<String> con = x -> System.out.println(x);
		con.accept("鎴戝ぇ灏氱璋峰▉姝︼紒");
	}
	
	@Test
	public void test3(){
		@SuppressWarnings("unused")
		Comparator<Integer> com = (x, y) -> {
			System.out.println("鍑芥暟寮忔帴鍙�");
			return Integer.compare(x, y);
		};
	}
	
	@Test
	public void test4(){
		@SuppressWarnings("unused")
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
	}
	
	@Test
	public void test5(){
//		String[] strs;
//		strs = {"aaa", "bbb", "ccc"};
		
		@SuppressWarnings("unused")
		List<String> list = new ArrayList<>();
		
		show(new HashMap<>());
	}

	public void show(Map<String, Integer> map){
		
	}
	
	//闇�姹傦細瀵逛竴涓暟杩涜杩愮畻
	@Test
	public void test6(){
		Integer num = operation(100, (x) -> x * x);
		System.out.println(num);
		
		System.out.println(operation(200, (y) -> y + 200));
	}
	
	public Integer operation(Integer num, MyFun mf){
		return mf.getValue(num);
	}
}
