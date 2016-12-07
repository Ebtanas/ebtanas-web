(ns ebtanas.pub.common)

(defn widget
  [title & args]
  [:div [:h1 title]])

(defn input
  [type id class name placeholder & [maps]]
  [:input
   (let [attribute {:type type
                    :id id
                    :className class
                    :name name
                    :placeholder placeholder}]
     (if maps
       (merge attribute maps)
       attribute))])

(defn form-group
  [label-component input-component & [class1 class2]]
  [:div.form-group
   [:div (if-not class1
           {:className "col-4"}
           {:className class1}) label-component]
   [:div (if-not class2
           {:className "col-5"}
           {:className class2}) input-component]])

(defn form-layout-two-columns
  [column1 column2]
  [:section.body.section.columns
   [:section.container.grid-960.mt-10
    [:div.columns.col-oneline
     [:div.column.col-6
      [:div.informations column1]]
     [:div.column.col-6
      [:div.column.signup-form column2]]]]])
