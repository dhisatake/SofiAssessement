package MovieDB

import groovy.json.JsonOutput

class CSVtoJSON {

    // Some of the limitations are if the CSV file contains commas in the string it doesn't parse correctly.
    // I Would need to implement a more complex CSV reader to allow for that
    def "convert"(String filepath) {
        def file = new File(filepath)
        if (!file.exists()) {
            println("file doesn't exist")
        }

        def lines = file.readLines()
        def keys = lines[0].split(',')
        def rows = lines[1..-1].collect { line ->
            def i = 0, vals = line.split(',')
            keys.inject([:]) { map, key -> map << ["$key": vals[i++]] }
        }
        def output = JsonOutput.toJson(rows)
        return output
    }

}
