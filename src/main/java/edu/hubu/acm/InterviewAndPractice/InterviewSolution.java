package edu.hubu.acm.InterviewAndPractice;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName InterviewSolution.java
 * @Description TODO
 * @createTime 2019年08月16日 20:34:00
 */
public class InterviewSolution {
    //作业帮笔试题——有序序列中查找两数之和等于目标数字的项
    public void searchEqualItem(int[] array, int key) {
        Map<Integer, Integer> items = new HashMap<Integer, Integer>();
        int middle = key / 2;
        int middleIndex = 0;
        for (; middleIndex < array.length; ++middleIndex) {
            if (array[middleIndex] > middle) {
                break;
            }
        }
        for (int i = 0; i < middleIndex; ++i) {
            for (int j = middleIndex; j < array.length; ++j) {
                if (array[i] + array[j] == key) {
                    items.put(i, j);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
            System.out.println(array[entry.getKey()] + "," + array[entry.getValue()]);
        }
    }

    public String reverseString(String str) {
        char[] charArray = str.toCharArray();
        for (int left = 0, right = charArray.length - 1; left < right; ++left, --right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
        }
        return String.valueOf(charArray);
    }

    //百度面试题——将一个表示ip地址的字符串转换为对应的整数
    public long translateIpAddressToInt(String ipstr) {
        long ipValue = 0L;
        String[] ipArray = ipstr.split(Pattern.quote("."));
        for (int i = 0; i < ipArray.length; ++i) {
            long ipNumber = Long.valueOf(ipArray[i]) << (8 * (3 - i));
            ipValue = ipValue | ipNumber;
        }
        return ipValue;
    }

    public int countSubstring() {
        String str, substr;
        System.out.print("请输入目标串:");
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.print("请输入待查找的子串:");
        substr = scanner.nextLine();
        int count = 0, index = 0;
        while ((index = str.indexOf(substr)) != -1) {
            ++count;
            str = str.substring(index + substr.length());
        }
        return count;
    }

    //科大讯飞笔试题———用递归二分法查找
    public int binaryRecursiveSearch(int[] array, int left, int end, int target) {
        int index = -1;
        int middle = (left + end) / 2;
        if (left > end) {
            return index;
        }
        if (array[middle] == target) {
            return middle + 1;
        } else {
            if (target < array[middle]) {
                end = middle - 1;
                return binaryRecursiveSearch(array, left, end, target);
            } else {
                left = middle + 1;
                return binaryRecursiveSearch(array, left, end, target);
            }
        }
    }

    //    腾讯笔试题——一排并列的楼栋在每个位置能看到的楼栋数量
    public int[] numberOfBuildingSeen(int[] buildingHeight) {
        int[] buildingSeen = new int[buildingHeight.length];
        int length = buildingHeight.length;
        for (int i = 0; i < length; ++i) {
            int count = 0;
            if (i == 0 || i == length - 1) {
                count = 2;
            } else {
                count = 3;
            }
            int leftMax = (i == 0) ? Integer.MAX_VALUE : buildingHeight[i - 1];
            for (int j = i - 2; j >= 0; --j) {
                if (leftMax < buildingHeight[j]) {
                    ++count;
                    leftMax = buildingHeight[j];
                }
            }
            int rightMax = (i == length - 1) ? Integer.MAX_VALUE : buildingHeight[i + 1];
            for (int k = i + 2; k < length; ++k) {
                if (rightMax < buildingHeight[k]) {
                    ++count;
                    rightMax = buildingHeight[k];
                }
            }
            buildingSeen[i] = count;
        }
        return buildingSeen;
    }

    public void minimumBoatCount() {
        Scanner in = new Scanner(System.in);
        String[] peopleWeight = in.nextLine().split(" ");
        int limit = in.nextInt();
        int peopleCount = peopleWeight.length;
        int[] p = new int[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            p[i] = Integer.parseInt(peopleWeight[i]);
        }
        Arrays.sort(p);
        int i = 0, j = peopleCount - 1;
        int count = peopleCount;
        while (i < j) {
            if (p[i] + p[j] <= limit) {
                count--;
                i++;
                j--;
            } else
                j--;
        }
        System.out.println(count);
    }

    /**
     * @Description:快手笔试题，判断两个版本号该不该升级
     * @Param: [version1, version2]
     * @return: boolean
     * @Author: zhoulei
     * @Date: 2019/8/25
     */
    public boolean versionCompareV1(String version1, String version2) {
        boolean flag = false;
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int version1ArrayLength = version1Array.length;
        int version2ArrayLength = version2Array.length;
        int maxLength = version1ArrayLength > version2ArrayLength ? version1ArrayLength : version2ArrayLength;
        if (version1ArrayLength < version2ArrayLength) {
            version1Array = Arrays.copyOf(version1Array, version2ArrayLength);
            for (int i = version1ArrayLength; i < version2ArrayLength; ++i) {
                version1Array[i] = "0";
            }
        }
        if (version2ArrayLength < version1ArrayLength) {
            version2Array = Arrays.copyOf(version2Array, version1ArrayLength);
            for (int i = version2ArrayLength; i < version1ArrayLength; ++i) {
                version2Array[i] = "0";
            }
        }
        for (int j = 0; j < maxLength; ++j) {
            if (Integer.valueOf(version2Array[j]) > Integer.valueOf(version1Array[j])) {
                return true;
            }
        }
        return flag;
    }

    /**
     * @Description:
     * @Param: [version1, version2]
     * @return: boolean
     * @Author: zhoulei
     * @Date: 2019/8/25
     */
    public boolean versionCompareV2(String version1, String version2) {
        boolean flag = false;
        String version1_new = version1.replaceAll(Pattern.quote("."), "");
        String version2_new = version2.replaceAll(Pattern.quote("."), "");
        int version1_length = version1_new.length();
        int version2_length = version2_new.length();
        StringBuffer tempBuffer = new StringBuffer();
        if (version1_length < version2_length) {
            int subSixe = version2_length - version1_length;
            while (subSixe-- > 0) {
                tempBuffer.append('0');
            }
            version1_new = version1_new + tempBuffer.toString();
        }
        if (version2_length < version1_length) {
            int subSixe = version1_length - version2_length;
            while (subSixe-- > 0) {
                tempBuffer.append('0');
            }
            version2_new = version2_new + tempBuffer.toString();
        }
        if (Long.valueOf(version2_new) > Long.valueOf(version1_new)) {
            return true;
        }
        return flag;
    }

    public void smallestExpression() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] valueAndOperation = line.split(" ");
        int length = valueAndOperation.length;
        for (int i = 1; i < length - 3; ++i) {
            if (valueAndOperation[i] == valueAndOperation[i + 2]) {
            }
        }
        System.out.println("1 + 2 + 3 + -5 * -4 + 1 ");
    }

    public void getGem() {
        Scanner scanner = new Scanner(System.in);
        int n, Total, Cost;
        n = scanner.nextInt();
        Total = scanner.nextInt();
        Cost = scanner.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; ++i) {
            A[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; ++j) {
            B[j] = scanner.nextInt();
        }
        System.out.println(A[n - 1]);
    }

    /**
     * @Description:顺丰科技笔试题——求最长的递增子序列
     * @Param: [arr]
     * @return: int
     * @Author: zhoulei
     * @Date: 2019/8/29
     */
    public static int longestSubSquence(int[] arr) {
        int[] longestSubSquenceArray = new int[arr.length - 1];
        int maxLength = 1;
        int length = arr.length;
        for (int i = 0; i < length - 1; ++i) {
            longestSubSquenceArray[i] = 1;
            int max = arr[i];
            int j = i + 1;
            while (j < length) {
                if (max <= arr[j]) {
                    ++longestSubSquenceArray[i];
                    max = arr[j];
                }
                ++j;
            }
            maxLength = longestSubSquenceArray[i] > maxLength ? longestSubSquenceArray[i] : maxLength;

        }
        return maxLength;
    }

    public static List<Map.Entry<Integer, Integer>> symmetrySubSquence(int[] arr) {
        int maxLength = 1;
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < length - 1) {
            int subLength = 0;
            int j = i;
            while (i < length - 1 && arr[i + 1] > arr[i]) {
                ++subLength;
                ++i;
            }
            if (subLength > 0) {
                while (i < length - 1 && arr[i + 1] < arr[i]) {
                    ++subLength;
                    ++i;
                }
            }
            map.put(j, subLength);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        return list;
    }

    public static int leastMachine() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int leastMachineCount = 0;
        Map<Integer, Integer> langluageMap = new HashMap<>();
        for (int i = 0; i < k; ++i) {
            langluageMap.put(scanner.nextInt(), scanner.nextInt());
        }
        for (int j = 1; j < n; ++j) {
            if (langluageMap.get(j) == null) {
                ++leastMachineCount;
            } else {
                if (langluageMap.get(j) != langluageMap.get(j + 1)) {
                    ++leastMachineCount;
                }
            }

        }
        return leastMachineCount;
    }

    /**
     * @Description:车好多集团笔试第一题——（求数列中缺失的最小正整数）
     * @Param: []
     * @return: void
     * @Author: zhoulei
     * @Date: 2019/9/3
     */
    public void smallestMissingInteger() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> originList = new ArrayList();
        for (int i = 0; i < n; ++i) {
            originList.add(scanner.nextInt());
        }
        List<Integer> list = originList.stream().filter(i -> i > 0).sorted().collect(Collectors.toList());
        int size = list.size();
        int i = 0;
        for (; i < size; ++i) {
            if (list.get(i) != i + 1) {
                System.out.println(i + 1);
                break;
            }
        }
        if (i == size) {
            System.out.println(i + 1);
        }
    }

    /**
     * @Description:将一组整数重新组合形成最大的整数
     * @Param: [nums]
     * @return: java.lang.String
     * @Author: zhoulei
     * @Date: 2019/9/3
     */
    public static String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        //防止测试用例中出现了[0,0,0]的情况，按道理应该返回"0"
        if (strArr[0].equals("0")) {
            return "0";
        }
        for (String temp : strArr) {
            sb.append(temp);
        }
        return sb.toString();
    }

    /**
     * @Description:携程笔试题，以某一数字为分隔，比起大的放在后面，否则放在前面
     * @Param: [head, m] 
     * @return: edu.hubu.acm.InterviewAndPractice.ListNode
     * @Author: zhoulei
     * @Date: 2019/9/4 
     */
    /**
     * @Description:携程笔试题，以某一数字为分隔，比起大的放在后面，否则放在前面
     * @Param: [head, m] 
     * @return: edu.hubu.acm.InterviewAndPractice.ListNode
     * @Author: zhoulei
     * @Date: 2019/9/4 
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    static ListNode partition(ListNode head, int m) {
        List<Integer> lowerList = new ArrayList<>();
        List<Integer> uperList = new ArrayList<>();
        ListNode tailNode=head;
        while (tailNode != null) {
            if (tailNode.val <= m) {
                lowerList.add(tailNode.val);
            } else {
                uperList.add(tailNode.val);
            }
            tailNode = tailNode.next;
        }
        if (lowerList.size() > 0) {
            head= new ListNode(lowerList.get(0));
            tailNode=head;
            int lowerSize = lowerList.size();
            for (int i = 1; i < lowerSize; ++i) {
                tailNode.next = new ListNode(lowerList.get(i));
                tailNode = tailNode.next;
            }
            int uperSize = uperList.size();
            for (int i = 0; i < uperSize; ++i) {
                tailNode.next = new ListNode(lowerList.get(i));
                tailNode = tailNode.next;
            }
            return head;
        }
        else {
            return head;
        }
    }
}

//搜狗笔试题——关联Map
class RelationMap {
    private int N = 0;
    private List<RelationEntry> rationMap = new ArrayList<>();
    public void insert(String key, Integer value) {
        RelationEntry relationEntry = new RelationEntry();
        relationEntry.setKey(key);
        relationEntry.setValue(value);
        int size = rationMap.size();
        int i = 0;
        for (; i < size; ++i) {
            if (rationMap.get(i).getKey() == key && rationMap.get(i).getValue() < value) {
                for (int j = i; j < size - 1; ++j) {
                    rationMap.set(j, rationMap.get(j + 1));
                }
                rationMap.set(size - 1, relationEntry);
                return;
            }
        }
        if (i == size) {
            if (size < N) {
                rationMap.add(relationEntry);
            } else {
                System.out.println(rationMap.get(0).getKey() + " " + rationMap.get(0).getValue());
                for (int k = 0; k < size - 1; ++k) {
                    rationMap.set(k, rationMap.get(k + 1));
                }
                rationMap.set(size - 1, relationEntry);
            }
        }
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }
}

class RelationEntry {
    private String key;
    private Integer value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    /** 
    * @Description:B站笔试题——求和等于整数target的连续序列都多少个
    * @Param: [target]
    * @return: int 
    * @Author: zhoulei 
    * @Date: 2019/9/10 
    */ 
    public static int SumContinuousSequence(int target) {
        int n = target;
        int count = 1;
        if (n<3) {
            return count;
        }
        for (int i = 2; (2 * i - 1) * (2 * i - 1) - 1 < 8 * n; i++) {//将求根转化为平方。例如 i<sqrt(x)-->i*i<n
            if ((n - i * (i - 1) / 2) % i == 0) {
                int x = (n - i * (i - 1) / 2) / i;
                int j = 0;
                while (j < i) {
                    x++;
                    j++;
                }
                ++count;
            }
        }
        return count;
    }

    public static int Maxsum(int[][] arr) {
        int maxumum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                int[] n = new int[arr[0].length];
                for (int w = 0; w < arr[0].length; w++) {
                    sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum = sum + arr[k][w];
                    }
                    n[w] = sum;
                }
                if (linearArrayMaxsum(n) > maxumum)
                    maxumum = linearArrayMaxsum(n);
            }
        }
        return maxumum;
    }

    public static int linearArrayMaxsum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static int miniCookie(int[] scores) {
        if (scores == null || scores.length == 0) {
            return 0;
        }
        int[] count = new int[scores.length];
        //每个孩子都至少有一块饼干
        Arrays.fill(count, 1);
        int sum = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }

        for (int i = scores.length - 1; i > 0; i--) {
            sum += count[i];
            if (scores[i] < scores[i - 1] && count[i] >= count[i - 1]) {
                count[i - 1] = count[i] + 1;
            }
        }
        sum += count[0];
        return sum;
    }

    public static void solution(){
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        int[] results=new int[str.length()];//存放每个机器人最后存放位置
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='L'){
                for(int j=i-1;j>=0;j--){
                    if(str.charAt(j)=='R'){
                        if((i-j)%2==0){
                            results[j]++;
                        }else{
                            results[j+1]++;
                        }
                        break;
                    }

                }
            }
            else{
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(j)=='L'){
                        if((j-i)%2==0){
                            results[j]++;
                        }else{
                            results[j-1]++;
                        }
                        break;
                    }

                }
            }
        }
        for(int i=0;i<str.length();i++){
            System.out.print(results[i]+" ");
        }
    }


}


