    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            //	asignam o clasa din fisierul css in fct de exp regulata 
            String styleClass =
                    matcher.group("KEYS") != null ? "keys" :
                    matcher.group("BASICTERMS") != null ? "basicTerms" :
                    matcher.group("NONCES") != null ? "nonces" :
                    matcher.group("AGENTS") != null ? "agents" :
                    matcher.group("BRACES") != null ? "braces" :
                    matcher.group("PARAN") != null ? "paran" :
                    null; /* never happens */ assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }