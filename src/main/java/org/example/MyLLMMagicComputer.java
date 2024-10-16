package org.example;

import org.apache.commons.lang.StringUtils;

import java.util.UUID;

public class MyLLMMagicComputer {
    private final String brainName;
    private final String url;
    private final UUID apiKey;

    private MyLLMMagicComputer(String brainName, String url, UUID apiKey) {
        this.brainName = brainName;
        this.url = url;
        this.apiKey = apiKey;
    }

    public static MyLLMMagicComputerBuilder builder(){
        return new MyLLMMagicComputerBuilder();
    }

    public Guess guessWhat(String someTokenIWant) {
        if (someTokenIWant == null) return new Guess("You tried to hacked me", null, Double.NaN, Double.NaN, Double.NaN);
        if (someTokenIWant.isEmpty()) return new Guess("You could be smarter", null, Double.NaN, Double.NaN, Double.NaN);
        if (someTokenIWant.isBlank()) return new Guess("No much stuff to work on", null, Double.NaN, Double.NaN, Double.NaN);
        if (someTokenIWant.toLowerCase().equals(someTokenIWant)) return new Guess("You could use upper cases sometime", someTokenIWant, 1., 0., 0.);
        if (someTokenIWant.toUpperCase().equals(someTokenIWant)) return new Guess("You could use lower cases sometime", someTokenIWant, 0., 1., 0.);

        int count = StringUtils.countMatches(someTokenIWant.toLowerCase(), "jack");
        if(count == 1) {
            return new Guess("Perfect Jack", someTokenIWant.toLowerCase(), .25, 0.25, 0.5);
        }
        if(count > 1) {
            return new Guess("Jack lacks of humility", someTokenIWant.toLowerCase(), .25, 0.5, 0.25);
        }

        return new Guess("Perfect", someTokenIWant.toLowerCase(), .5, 0.25, 0.25);
    }

    public static class MyLLMMagicComputerBuilder {
        private String brainName;
        private String url;
        private UUID apiKey;

        public MyLLMMagicComputerBuilder useBrain(String brainName){
            this.brainName = brainName;
            return this;
        }

        public MyLLMMagicComputerBuilder useUrl(String url){
            this.url = url;
            return this;
        }
        public MyLLMMagicComputerBuilder useApiKey(UUID apiKey){
            this.apiKey = apiKey;
            return this;
        }
        public MyLLMMagicComputer build(){ return new MyLLMMagicComputer(brainName, url, apiKey); }
    }
}
