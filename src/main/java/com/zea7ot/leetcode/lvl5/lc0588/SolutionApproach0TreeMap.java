/**
 * https://leetcode.com/problems/design-in-memory-file-system/
 * 
 * 
 * References:
 *  https://leetcode.com/problems/design-in-memory-file-system/discuss/196035/OOP-Java-Solution-beat-100
 */
package com.zea7ot.leetcode.lvl5.lc0588;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SolutionApproach0TreeMap {
    private FileNode root;
    
    public SolutionApproach0TreeMap() {
        root = new FileNode("");
    }
    
    public List<String> ls(String path) {
        return findNode(path).getList();
    }
    
    public void mkdir(String path) {
        findNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }
    
    private FileNode findNode(String path){
        String[] files = path.split("/");
        
        FileNode cur = root;
        for(String file : files){
            if(file.isEmpty()) continue;
            
            cur.children.putIfAbsent(file, new FileNode(file));
            cur = cur.children.get(file);
            
            if(cur.isFile()) break;
        }
        
        return cur;
    }
    
    private class FileNode{
        private TreeMap<String, FileNode> children;
        private StringBuilder file;
        private String name;
        
        protected FileNode(String name){
            this.children = new TreeMap<String, FileNode>();
            this.file = new StringBuilder();
            this.name = name;
        }
        
        protected String getContent(){
            return file.toString();
        }
        
        protected String getName(){
            return name;
        }
        
        protected void addContent(String content){
            file.append(content);
        }
        
        protected boolean isFile(){
            return file.length() > 0;
        }
        
        protected List<String> getList(){
            List<String> list = new ArrayList<String>();
            if(isFile()) list.add(getName());
            else list.addAll(children.keySet());
            return list;
        }
    }
}