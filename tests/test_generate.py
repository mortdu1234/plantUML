from src.auto_graph.generate import generate

print(generate._code_path)
generate.code_add_path("name")
print(generate._code_path)
generate.code_sub_path()
print(generate._code_path)