package com.project.orders_service.feingClientReturn;

import lombok.Getter;
import lombok.Setter;


public class ResponseFeign {

        private Data data;


        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }



}
