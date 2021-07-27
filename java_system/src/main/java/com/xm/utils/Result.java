package com.xm.utils;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

@Component
public class Result {

        private int code;         //状态码
        private String msg;       //消息
        private int  count;       //记录条数
        private Object data;      //数据对象

        /**
         * 无参构造器
         */
        public Result(){
            super();
        }

        /**
         * 只返回状态码，消息
         * @param code
         * @param msg
         */
        public Result(int code, String msg){
            super();
            this.code=code;
            this.msg=msg;
        }

        /**
         只返回状态码，消息，数据对象
         @param code
         @param msg
         @param data
         */
        public Result(int code, String msg, Object data){
            super();
            this.code=code;
            this.msg=msg;
            this.data=data;
        }

        /**
         * 返回全部信息即:状态码，消息，记录条数，数据对象
         * @param code
         * @param msg
         * @param count
         * @param data
         */
        public Result(int code, String msg, int count, Object data){
            super();
            this.code=code;
            this.msg=msg;
            this.count=count;
            this.data=data;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }

/*    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }*/


}
