from .generate import generate
import re

class java(generate):

    @classmethod
    def content(cls):
        """select all things that will be added in the .plantuml

        Returns:
            string: data of the .plantuml
        """
        print("content")
        result = ""
        if cls.all_packages:
            result += cls.package("Western") 
        return result
    

    @classmethod
    def interaction(cls):
        """check all files and find all interraction between class and return all interraction

        Returns:
            string: all interraction between class
        """
        print("interaction")
        interraction = [("extends", "<|--") , ("Composition", "*--") , ("Aggregation", "o--")]
        data = ""
        result = ""
        for code_file in cls.get_files(".java"):
            with open(f"{cls.get_code_path()}{code_file}", "r") as file:
                data += file.read() + "\n"
        for inter, uml in interraction:
            pattern = rf"([a-zA-Z]+)\s(?:{inter})\s([a-zA-Z]+)"
            detected = re.findall(pattern, data)
            if detected:
                for subclass, mainclass in detected:
                    result += cls.tab() + f"{mainclass} {uml} {subclass}\n"
        return result

    @classmethod
    def attribute(cls, data):
        print("attribute")
        """check all attribute in a certain data

        Args:
            data (String): all the code of one file

        Returns:
            String: all attribute of the class
        """
        visibility = [("private", "-") , ("public", "+") , ("protected", "#"), ("package", "~")]
        result = ""

        for v, uml in visibility:
            pattern = rf"\b(?:{v})\s(?:final|static)*\s*(?:final|static)*\s*([a-zA-Z<>]+)\s([a-zA-Z\d]+)\s*(?:=[^;]+)?;"
            detected = re.findall(pattern, data)
            if detected:
                for attribute_type, attribute_name in detected:
                    result += cls.tab() + f"{uml}{attribute_name} : {attribute_type}\n"
        return result


    @classmethod
    def class_data(cls, data):
        print("class_data")
        """check all things for a certain class

        Args:
            data (String): all the code of one file

        Returns:
            String: all the class
        """
        pattern = r"\bclass\s(\w+)"
        deteced = re.findall(pattern, data)
        result = ""
        if deteced:
            for class_name in deteced:
                result += cls.tab() + f"class {class_name} " + "{\n"
                cls.add_tab()
                if cls.all_attribute:
                    result += cls.attribute(data)

        cls.sub_tab()
        return result + cls.tab() + "}\n"


    @classmethod
    def file(cls, code_file):
        print("file")
        """read all the data in a code file

        Args:
            code_file (String): name of this file, with the extention

        Returns:
            String: data of one file
        """
        # get the data of the file
        result = ""
        with open(f"{cls.get_code_path()}{code_file}", "r") as file:
            data = file.read()
        if cls.all_class:
            result += cls.class_data(data)
        return result


    @classmethod
    def package(cls, name):
        print("package")
        """check everythings for one package java

        Args:
            name (String): name of this package

        Returns:
            String: all in the package
        """
        result = cls.tab() + f"package {name}" + " {\n"
        cls.add_tab()
        cls.code_add_path(name)

        codes_files = cls.get_files(".java")
        # get the data for each class
        for code_file in codes_files:
            result += cls.file(code_file) + cls.tab() + "\n" 
        
        # get interraction between class
        if cls.all_interaction:
            result += cls.interaction()

        cls.sub_tab()
        return result + cls.tab() + "}\n"
    
