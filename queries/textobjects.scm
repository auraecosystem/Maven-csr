;; queries/textobjects.scm - Tree-Sitter Textobject Queries

;; -----------------------------------------------------------------------------
;; Functions & Methods
;; -----------------------------------------------------------------------------
;; 'af' (around function) - captures the entire function signature and body
(function_declaration) @function.outer

;; 'if' (inside function) - captures only the inner body block
(function_declaration
  body: (statement_block) @function.inner)

;; -----------------------------------------------------------------------------
;; Structs / Classes
;; -----------------------------------------------------------------------------
;; 'ac' (around class/struct)
(struct_declaration) @class.outer

;; 'ic' (inside class/struct body)
(struct_declaration
  body: (struct_block) @class.inner)

;; -----------------------------------------------------------------------------
;; Loops
;; -----------------------------------------------------------------------------
;; 'al' (around loop)
(for_statement) @loop.outer
(while_statement) @loop.outer

;; 'il' (inside loop body)
(for_statement body: (statement_block) @loop.inner)
(while_statement body: (statement_block) @loop.inner)

;; -----------------------------------------------------------------------------
;; Conditionals (if / else)
;; -----------------------------------------------------------------------------
(if_statement) @conditional.outer

(if_statement 
  consequence: (statement_block) @conditional.inner)

;; -----------------------------------------------------------------------------
;; Parameters & Arguments
;; -----------------------------------------------------------------------------
;; 'a' / 'i' parameter targets
(parameter) @parameter.inner
(parameter_list) @parameter.outer

(argument_list) @parameter.outer
