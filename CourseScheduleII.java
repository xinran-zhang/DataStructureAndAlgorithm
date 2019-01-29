package grace.shuati;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // use a list to maintain the courses that need course i to be its pres
        // use a int list to maintain the in-degree of each courses
        // use a queue to realize BFS
        // use a int list to record the ordering courses
        // add all 0 in-degree to the queue first
        // poll from the queue ,at the same time -1 from its relational courses -> add 0 degree to the queue
        int[] degree = new int[numCourses];
        ArrayList[] courseList = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            courseList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            courseList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[count] = course;
            count++;
            int size = courseList[course].size();
            for (int i = 0; i < size; i++) {
                int pointer = (int)courseList[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }
        if (count != numCourses) return new int[0];
        return result;
    }
}
