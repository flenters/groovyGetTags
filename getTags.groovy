import groovy.json.JsonSlurper
// GET
try {
    def get = new URL("http://yourinternalnexusurl:8018/applicacation/v1...etc").openConnection();
    def conn = get.getResponseCode();
    if (conn.equals(200)) {
        def nexus_response = [:]
        nexus_response = new JsonSlurper().parseText(get.getInputStream().getText())
        def image_tag_list = []
        for (tag in nexus_response.items.version){
            image_tag_list.add(tag)
        }
       return image_tag_list.sort()
    }
}catch(Exception e){
    println(e)
}
