from abc import ABC, abstractmethod
import os

class generate(ABC):
    _title = "title" # title of the plantuml graph
    _code_path = "code_src/src/" # path of the code that will be checked
    _file_save_name = "diagram" # name of the .plantuml file
    _save_path = "uml/" # path of the .plantuml file
    _nb_tab = 0 # number of tab
    
    # things to add in the diagram
    all_packages = True
    all_class = True
    all_attribute = True
    all_interaction = True



    @classmethod
    def create_file(cls):
        """create a fil .plantuml
        """
        with open(f"{cls._save_path}{cls._file_save_name}.plantuml", "w") as file:
            file.write(f"@startuml {cls._title}\n")
            file.write(cls.content())  
            file.write("\n@enduml\n")

    @classmethod
    def get_files(cls, file_type):
        """get all file of a certain type

        Args:
            file_type (string): extention of the file

        Returns:
            list[str]: list of files with this extention
        """
        files = os.listdir(cls.get_code_path())
        res = []
        for file in files:
            if file[-len(file_type):] == file_type:
                res.append(file)
        return res
    
    @classmethod
    @abstractmethod
    def content(cls):
        """select all things that will be added in the .plantuml
        """
        pass 

    @classmethod
    def tab(cls):
        """return the indent

        Returns:
            string: indent
        """
        return " "*4*cls._nb_tab
    
    @classmethod
    def add_tab(cls):
        """add 1 to the number of indent
        """
        cls._nb_tab += 1

    @classmethod
    def sub_tab(cls):
        """sub 1 to the number of indent
        """
        cls._nb_tab -= 1
    
    @classmethod
    def code_add_path(cls, directory):
        """add a new directory in for the code path

        Args:
            directory (string): the name of the directory
        """
        cls._code_path += directory + "/"

    @classmethod
    def code_sub_path(cls):
        """remove the last directory for the code path
        """
        list_directory = cls._code_path.split("/")
        new_code_path = ""
        for idx_directory in range(0, len(list_directory)-2):
            new_code_path += list_directory[idx_directory] + "/"
        cls._code_path = new_code_path
    
    @classmethod
    def get_code_path(cls):
        """getter of code path

        Returns:
            string: the path where is the code to check
        """
        return cls._code_path