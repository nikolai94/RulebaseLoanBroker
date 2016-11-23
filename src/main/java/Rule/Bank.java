/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rule;

/**
 *
 * @author nikolai
 */
public class Bank {
    private String name;
    private String routingKey;
    private Integer minScore;

    public Bank(String name, String routingKey, Integer minScore) {
        this.name = name;
        this.routingKey = routingKey;
        this.minScore = minScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }
    
    
}
