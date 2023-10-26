package com.example.demo;

import java.io.Serializable;
import java.util.Objects;



    public class Entity implements Serializable {

        private int id;

        public Entity() {
        }

        public Entity(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entity)) return false;
            Entity entity = (Entity) o;
            return id == entity.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "id=" + id +
                    '}';
        }
    }


