package com.example.tassioflix.model.entity;

public class Oscar {

        private int id;
        private String name;
        private String sloganTagLine;

        public Oscar(int id, String name, String sloganTagLine) {
            this.id = id;
            this.name = name;
            this.sloganTagLine = sloganTagLine;
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSloganTagline() {
            return sloganTagLine;
        }

        public void setSloganTagLine(String sloganTagLine) {
            this.sloganTagLine = sloganTagLine;
        }


}
