import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 그룹명 -> 멤버 목록
        Map<String, ArrayList<String>> groupToMembers = new HashMap<>();
        // 멤버 이름 -> 그룹명
        Map<String, String> memberToGroup = new HashMap<>();
        
        // N개의 걸그룹 정보 입력
        for(int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            
            ArrayList<String> members = new ArrayList<>();
            for(int j = 0; j < memberCount; j++) {
                String memberName = br.readLine();
                members.add(memberName);
                memberToGroup.put(memberName, groupName);
            }
            Collections.sort(members);  // 사전순 정렬
            groupToMembers.put(groupName, members);
        }
        
        // M개의 퀴즈 처리
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());
            
            if(type == 0) {  // 팀 이름이 주어진 경우
                for(String member : groupToMembers.get(name)) {
                    sb.append(member).append("\n");
                }
            } else {  // 멤버 이름이 주어진 경우
                sb.append(memberToGroup.get(name)).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}