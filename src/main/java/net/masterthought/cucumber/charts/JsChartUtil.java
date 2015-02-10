package net.masterthought.cucumber.charts;

import net.masterthought.cucumber.TagObject;

import java.util.*;
import java.util.logging.Logger;

public class JsChartUtil {

    private static Logger logger = Logger.getLogger("net.masterthought.cucumber.charts.jschartutil");

    public List<String> orderStepsByValue(int numberTotalPassed, int numberTotalFailed, int numberTotalSkipped, int numberTotalPending) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();

        map.put("#C5D88A", numberTotalPassed);
        map.put("#D88A8A", numberTotalFailed);
        map.put("#2DEAEC", numberTotalSkipped);
        map.put("#ebcc81", numberTotalPending);

        return getKeysSortedByValue(map);
    }

    public List<String> orderScenariosByValue(int numberTotalPassed, int numberTotalFailed) {
        HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("#C5D88A", numberTotalPassed);
        map.put("#D88A8A", numberTotalFailed);

        return getKeysSortedByValue(map);
    }

    private List<String> getKeysSortedByValue(Map<String, Integer> map) {
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
       /* Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });*/


        List<String> keys = new LinkedList<String>();
        for (Map.Entry<String, Integer> entry : list) {
            keys.add(entry.getKey());
        }
        return keys;
    }

    public static String generateTagChartData(List<TagObject> tagObjectList) {
    	StringBuilder buffer = new StringBuilder();
        for (TagObject tag : tagObjectList) {
           buffer.append("[[" + tag.getNumberOfPasses() + "," + tag.getNumberOfFailures() + "," + tag.getNumberOfSkipped() + "," + tag.getNumberOfPending() + "],{label:'" + tag.getTagName() + "'}],");
        }
        return buffer.toString();
    }

    public static String getTags(List<TagObject> tagObjectList) {
        StringBuilder tags = new StringBuilder();

        if (!tagObjectList.isEmpty()) {
	        for (TagObject tag : tagObjectList) {
	            tags.append("'").append(tag.getTagName()).append("',");
	        }
	
	        tags.setLength(tags.length() - 1);
        }
        return "[" + tags.toString() + "]";
    }

    public static String generateTagChartDataForHighCharts(List<TagObject> tagObjectList) {
    	StringBuilder buffer = new StringBuilder();

        if (!tagObjectList.isEmpty()) {
	        for (TagObject tag : tagObjectList) {
	            buffer.append("[" + tag.getNumberOfPasses() + "," + tag.getNumberOfFailures() + "," + tag.getNumberOfSkipped() + "," + tag.getNumberOfPending() + "]").append(",");
	        }
	
	        buffer.setLength(buffer.length() - 1);
        }

        return "[" + buffer.toString() + "]";
    }



}
